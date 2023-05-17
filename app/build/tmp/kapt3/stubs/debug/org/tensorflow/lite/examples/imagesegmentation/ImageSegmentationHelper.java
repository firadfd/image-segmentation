package org.tensorflow.lite.examples.imagesegmentation;

import java.lang.System;

/**
 * Class responsible to run the Image Segmentation model. more information about the DeepLab model
 * being used can be found here:
 * https://ai.googleblog.com/2018/03/semantic-image-segmentation-with.html
 * https://github.com/tensorflow/models/tree/master/research/deeplab
 *
 * Label names: 'background', 'aeroplane', 'bicycle', 'bird', 'boat', 'bottle', 'bus', 'car', 'cat',
 * 'chair', 'cow', 'diningtable', 'dog', 'horse', 'motorbike', 'person', 'pottedplant', 'sheep',
 * 'sofa', 'train', 'tv'
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001d2\u00020\u0001:\u0002\u001d\u001eB+\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0002\u0010\tJ\u0006\u0010\u0016\u001a\u00020\u0017J\u0018\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0003H\u0007J\b\u0010\u001c\u001a\u00020\u0017H\u0002R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000f\u00a8\u0006\u001f"}, d2 = {"Lorg/tensorflow/lite/examples/imagesegmentation/ImageSegmentationHelper;", "", "numThreads", "", "currentDelegate", "context", "Landroid/content/Context;", "imageSegmentationListener", "Lorg/tensorflow/lite/examples/imagesegmentation/ImageSegmentationHelper$SegmentationListener;", "(IILandroid/content/Context;Lorg/tensorflow/lite/examples/imagesegmentation/ImageSegmentationHelper$SegmentationListener;)V", "getContext", "()Landroid/content/Context;", "getCurrentDelegate", "()I", "setCurrentDelegate", "(I)V", "getImageSegmentationListener", "()Lorg/tensorflow/lite/examples/imagesegmentation/ImageSegmentationHelper$SegmentationListener;", "imageSegmenter", "Lorg/tensorflow/lite/task/vision/segmenter/ImageSegmenter;", "getNumThreads", "setNumThreads", "clearImageSegmenter", "", "segment", "image", "Landroid/graphics/Bitmap;", "imageRotation", "setupImageSegmenter", "Companion", "SegmentationListener", "app_debug"})
public final class ImageSegmentationHelper {
    private int numThreads;
    private int currentDelegate;
    @org.jetbrains.annotations.NotNull
    private final android.content.Context context = null;
    @org.jetbrains.annotations.Nullable
    private final org.tensorflow.lite.examples.imagesegmentation.ImageSegmentationHelper.SegmentationListener imageSegmentationListener = null;
    private org.tensorflow.lite.task.vision.segmenter.ImageSegmenter imageSegmenter;
    @org.jetbrains.annotations.NotNull
    public static final org.tensorflow.lite.examples.imagesegmentation.ImageSegmentationHelper.Companion Companion = null;
    public static final int DELEGATE_CPU = 0;
    public static final int DELEGATE_GPU = 1;
    public static final int DELEGATE_NNAPI = 2;
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String MODEL_DEEPLABV3 = "deeplabv3.tflite";
    private static final java.lang.String TAG = "Image Segmentation Helper";
    
    public ImageSegmentationHelper(int numThreads, int currentDelegate, @org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.Nullable
    org.tensorflow.lite.examples.imagesegmentation.ImageSegmentationHelper.SegmentationListener imageSegmentationListener) {
        super();
    }
    
    public final int getNumThreads() {
        return 0;
    }
    
    public final void setNumThreads(int p0) {
    }
    
    public final int getCurrentDelegate() {
        return 0;
    }
    
    public final void setCurrentDelegate(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.content.Context getContext() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final org.tensorflow.lite.examples.imagesegmentation.ImageSegmentationHelper.SegmentationListener getImageSegmentationListener() {
        return null;
    }
    
    public final void clearImageSegmenter() {
    }
    
    private final void setupImageSegmenter() {
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.Q)
    public final void segment(@org.jetbrains.annotations.NotNull
    android.graphics.Bitmap image, int imageRotation) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J0\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH&\u00a8\u0006\u000f"}, d2 = {"Lorg/tensorflow/lite/examples/imagesegmentation/ImageSegmentationHelper$SegmentationListener;", "", "onError", "", "error", "", "onResults", "results", "", "Lorg/tensorflow/lite/task/vision/segmenter/Segmentation;", "inferenceTime", "", "imageHeight", "", "imageWidth", "app_debug"})
    public static abstract interface SegmentationListener {
        
        public abstract void onError(@org.jetbrains.annotations.NotNull
        java.lang.String error);
        
        public abstract void onResults(@org.jetbrains.annotations.Nullable
        java.util.List<? extends org.tensorflow.lite.task.vision.segmenter.Segmentation> results, long inferenceTime, int imageHeight, int imageWidth);
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lorg/tensorflow/lite/examples/imagesegmentation/ImageSegmentationHelper$Companion;", "", "()V", "DELEGATE_CPU", "", "DELEGATE_GPU", "DELEGATE_NNAPI", "MODEL_DEEPLABV3", "", "TAG", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}