package org.tensorflow.lite.examples.imagesegmentation;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u00192\u00020\u0001:\u0003\u0018\u0019\u001aB\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\u000b\u001a\u00020\fJ\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u000e\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\bJ&\u0010\u0011\u001a\u00020\f2\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00132\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Lorg/tensorflow/lite/examples/imagesegmentation/OverlayView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "listener", "Lorg/tensorflow/lite/examples/imagesegmentation/OverlayView$OverlayViewListener;", "scaleBitmap", "Landroid/graphics/Bitmap;", "clear", "", "draw", "canvas", "Landroid/graphics/Canvas;", "setOnOverlayViewListener", "setResults", "segmentResult", "", "Lorg/tensorflow/lite/task/vision/segmenter/Segmentation;", "imageHeight", "", "imageWidth", "ColorLabel", "Companion", "OverlayViewListener", "app_debug"})
public final class OverlayView extends android.view.View {
    @org.jetbrains.annotations.NotNull
    public static final org.tensorflow.lite.examples.imagesegmentation.OverlayView.Companion Companion = null;
    private static final int ALPHA_COLOR = 128;
    private android.graphics.Bitmap scaleBitmap;
    private org.tensorflow.lite.examples.imagesegmentation.OverlayView.OverlayViewListener listener;
    
    public OverlayView(@org.jetbrains.annotations.Nullable
    android.content.Context context, @org.jetbrains.annotations.Nullable
    android.util.AttributeSet attrs) {
        super(null);
    }
    
    public final void setOnOverlayViewListener(@org.jetbrains.annotations.NotNull
    org.tensorflow.lite.examples.imagesegmentation.OverlayView.OverlayViewListener listener) {
    }
    
    public final void clear() {
    }
    
    @java.lang.Override
    public void draw(@org.jetbrains.annotations.NotNull
    android.graphics.Canvas canvas) {
    }
    
    public final void setResults(@org.jetbrains.annotations.Nullable
    java.util.List<? extends org.tensorflow.lite.task.vision.segmenter.Segmentation> segmentResult, int imageHeight, int imageWidth) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&\u00a8\u0006\u0007"}, d2 = {"Lorg/tensorflow/lite/examples/imagesegmentation/OverlayView$OverlayViewListener;", "", "onLabels", "", "colorLabels", "", "Lorg/tensorflow/lite/examples/imagesegmentation/OverlayView$ColorLabel;", "app_debug"})
    public static abstract interface OverlayViewListener {
        
        public abstract void onLabels(@org.jetbrains.annotations.NotNull
        java.util.List<org.tensorflow.lite.examples.imagesegmentation.OverlayView.ColorLabel> colorLabels);
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0014\b\u0086\b\u0018\u00002\u00020\u0001B\'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\t\u0010\u0012\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\bH\u00c6\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bH\u00c6\u0001J\u0013\u0010\u0017\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\u0006\u0010\u0019\u001a\u00020\u0003J\t\u0010\u001a\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u001b\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\f\"\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000b\u00a8\u0006\u001c"}, d2 = {"Lorg/tensorflow/lite/examples/imagesegmentation/OverlayView$ColorLabel;", "", "id", "", "label", "", "rgbColor", "isExist", "", "(ILjava/lang/String;IZ)V", "getId", "()I", "()Z", "setExist", "(Z)V", "getLabel", "()Ljava/lang/String;", "getRgbColor", "component1", "component2", "component3", "component4", "copy", "equals", "other", "getColor", "hashCode", "toString", "app_debug"})
    public static final class ColorLabel {
        private final int id = 0;
        @org.jetbrains.annotations.NotNull
        private final java.lang.String label = null;
        private final int rgbColor = 0;
        private boolean isExist;
        
        @org.jetbrains.annotations.NotNull
        public final org.tensorflow.lite.examples.imagesegmentation.OverlayView.ColorLabel copy(int id, @org.jetbrains.annotations.NotNull
        java.lang.String label, int rgbColor, boolean isExist) {
            return null;
        }
        
        @java.lang.Override
        public boolean equals(@org.jetbrains.annotations.Nullable
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override
        public int hashCode() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull
        @java.lang.Override
        public java.lang.String toString() {
            return null;
        }
        
        public ColorLabel(int id, @org.jetbrains.annotations.NotNull
        java.lang.String label, int rgbColor, boolean isExist) {
            super();
        }
        
        public final int component1() {
            return 0;
        }
        
        public final int getId() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String component2() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getLabel() {
            return null;
        }
        
        public final int component3() {
            return 0;
        }
        
        public final int getRgbColor() {
            return 0;
        }
        
        public final boolean component4() {
            return false;
        }
        
        public final boolean isExist() {
            return false;
        }
        
        public final void setExist(boolean p0) {
        }
        
        public final int getColor() {
            return 0;
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lorg/tensorflow/lite/examples/imagesegmentation/OverlayView$Companion;", "", "()V", "ALPHA_COLOR", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}