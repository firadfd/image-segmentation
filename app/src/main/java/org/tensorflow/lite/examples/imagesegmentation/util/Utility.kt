package org.tensorflow.lite.examples.imagesegmentation.util

import android.content.Context
import android.graphics.Bitmap
import android.util.AttributeSet
import android.view.View
import org.tensorflow.lite.examples.imagesegmentation.OverlayView
import org.tensorflow.lite.task.vision.segmenter.Segmentation
import kotlin.math.max

class Utility(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    private var scaleBitmap: Bitmap? = null
    private var listener: OverlayView.OverlayViewListener? = null

    fun setResults(
        segmentResult: List<Segmentation>?,
        imageHeight: Int,
        imageWidth: Int,
    ): Bitmap? {
        if (segmentResult != null && segmentResult.isNotEmpty()) {
            val colorLabels = segmentResult[0].coloredLabels.mapIndexed { index, coloredLabel ->
                OverlayView.ColorLabel(
                    index, coloredLabel.getlabel(), coloredLabel.argb
                )
            }

            // Create the mask bitmap with colors and the set of detected labels.
            // We only need the first mask for this sample because we are using
            // the OutputType CATEGORY_MASK, which only provides a single mask.
            val maskTensor = segmentResult[0].masks[0]
            val maskArray = maskTensor.buffer.array()
            val pixels = IntArray(maskArray.size)

            for (i in maskArray.indices) {
                // Set isExist flag to true if any pixel contains this color.
                val colorLabel = colorLabels[maskArray[i].toInt()].apply {
                    isExist = true
                }
                val color = colorLabel.getColor()
                pixels[i] = color
            }

            val image = Bitmap.createBitmap(
                pixels, maskTensor.width, maskTensor.height, Bitmap.Config.ARGB_8888
            )

            // PreviewView is in FILL_START mode. So we need to scale up the bounding
            // box to match with the size that the captured images will be displayed.
            val scaleFactor = max(width * 1f / imageWidth, height * 1f / imageHeight)
            val scaleWidth = (imageWidth * scaleFactor).toInt()
            val scaleHeight = (imageHeight * scaleFactor).toInt()

            scaleBitmap = Bitmap.createScaledBitmap(image, scaleWidth, scaleHeight, false)
            listener?.onLabels(colorLabels.filter { it.isExist })

        }
        return scaleBitmap
    }
}