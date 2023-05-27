package org.tensorflow.lite.examples.imagesegmentation

import android.app.Activity
import android.content.ContentResolver
import android.content.Context
import android.content.Intent
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Matrix
import android.media.ExifInterface
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import org.tensorflow.lite.examples.imagesegmentation.databinding.ActivityPickImageBinding
import org.tensorflow.lite.task.vision.segmenter.Segmentation
import java.io.IOException

class PickImageActivity : AppCompatActivity(), ImageSegmentationHelper.SegmentationListener {
    private lateinit var binding: ActivityPickImageBinding
    private val PICK_IMAGE_REQUEST = 100
    private lateinit var imageSegmentationHelper: ImageSegmentationHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =
            DataBindingUtil.setContentView(this@PickImageActivity, R.layout.activity_pick_image)
        supportActionBar?.hide()

        imageSegmentationHelper = ImageSegmentationHelper(
            context = this@PickImageActivity,
            imageSegmentationListener = this
        )


        binding.button.setOnClickListener {
            pickImage()
        }


    }

    private fun pickImage() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(intent, PICK_IMAGE_REQUEST)
    }

    //    @RequiresApi(Build.VERSION_CODES.N)
    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK && data != null) {
            val selectedImageUri = data.data
            if (selectedImageUri != null) {
                val imageBitmap = getBitmapFromUri(selectedImageUri)
                val imageRotation = getImageRotation(this@PickImageActivity, selectedImageUri)

                if (imageBitmap != null) {
                    val resizedImage = resizeBitmap(imageBitmap,720,1080)
                    imageSegmentationHelper.segment(resizedImage, imageRotation)
                }
            }

        }
    }
    private fun resizeBitmap(bitmap: Bitmap, newWidth: Int, newHeight: Int): Bitmap {
        val width = bitmap.width
        val height = bitmap.height

        val scaleWidth = newWidth.toFloat() / width
        val scaleHeight = newHeight.toFloat() / height

        val matrix = Matrix()
        matrix.postScale(scaleWidth, scaleHeight)

        val resizedBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, false)
        bitmap.recycle()

        return resizedBitmap
    }

    @RequiresApi(Build.VERSION_CODES.N)
    fun getImageRotation(context: Context, imageUri: Uri): Int {
        val inputStream = context.contentResolver.openInputStream(imageUri)
        inputStream?.use { stream ->
            val exifInterface = ExifInterface(stream)

            val orientation = exifInterface.getAttributeInt(
                ExifInterface.TAG_ORIENTATION,
                ExifInterface.ORIENTATION_NORMAL
            )

            return when (orientation) {
                ExifInterface.ORIENTATION_ROTATE_90 -> 90
                ExifInterface.ORIENTATION_ROTATE_180 -> 180
                ExifInterface.ORIENTATION_ROTATE_270 -> 270
                else -> 0
            }
        }

        return 0
    }


    private fun calculateInSampleSize(
        options: BitmapFactory.Options,
        reqWidth: Int,
        reqHeight: Int
    ): Int {
        val imageWidth = options.outWidth
        val imageHeight = options.outHeight
        var inSampleSize = 1

        if (imageHeight > reqHeight || imageWidth > reqWidth) {
            val halfHeight = imageHeight / 2
            val halfWidth = imageWidth / 2

            while (halfHeight / inSampleSize >= reqHeight && halfWidth / inSampleSize >= reqWidth) {
                inSampleSize *= 2
            }
        }

        return inSampleSize
    }

    private fun getBitmapFromUri(uri: Uri): Bitmap? {
        try {
            val inputStream = contentResolver.openInputStream(uri)
            val options = BitmapFactory.Options()
            options.inJustDecodeBounds = true
            BitmapFactory.decodeStream(inputStream, null, options)

            // Calculate inSampleSize
            options.inSampleSize = calculateInSampleSize(options, 720, 1080)
            options.inJustDecodeBounds = false

            // Reset the input stream to start loading the full-sized image
            inputStream?.close()
            val newInputStream = contentResolver.openInputStream(uri)
            return BitmapFactory.decodeStream(newInputStream, null, options)
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return null
    }

    override fun onError(error: String) {
        this.runOnUiThread {
            Toast.makeText(this@PickImageActivity, error, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onResults(
        results: List<Segmentation>?,
        inferenceTime: Long,
        imageHeight: Int,
        imageWidth: Int
    ) {
        this.runOnUiThread {

            binding.overlay.setResults(
                results,
                imageHeight,
                imageWidth
            )

            // Force a redraw
            binding.overlay.invalidate()
        }
    }


}