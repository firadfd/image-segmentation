package org.tensorflow.lite.examples.imagesegmentation

import android.app.Activity
import android.content.ContentResolver
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
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
//                val imageRatio = getImageSizeRatio(this@PickImageActivity, selectedImageUri)
                val imageBitmap = getBitmapFromUri(this@PickImageActivity, selectedImageUri)
                val imageRotation = getImageRotation(this@PickImageActivity, selectedImageUri)

                if (imageBitmap != null) {
                    imageSegmentationHelper.segment(imageBitmap, imageRotation)
                }
            }

        }
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

    private fun getImageSizeRatio(context: Context, uri: Uri): Float {
        val contentResolver: ContentResolver = context.contentResolver

        val options = BitmapFactory.Options()
        options.inJustDecodeBounds = true

        val inputStream = contentResolver.openInputStream(uri)
        BitmapFactory.decodeStream(inputStream, null, options)
        inputStream?.close()

        val width = options.outWidth
        val height = options.outHeight
        val ratio = width.toFloat() / height.toFloat()

        return ratio
    }

    private fun getBitmapFromUri(context: Context, uri: Uri): Bitmap? {
        val contentResolver: ContentResolver = context.contentResolver

        try {
            val inputStream = contentResolver.openInputStream(uri)
            val bitmap = BitmapFactory.decodeStream(inputStream)
            inputStream?.close()
            return bitmap
        } catch (e: Exception) {
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
//            fragmentCameraBinding.bottomSheetLayout.inferenceTimeVal.text =
//                String.format("%d ms", inferenceTime)

            // Pass necessary information to OverlayView for drawing on the canvas

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