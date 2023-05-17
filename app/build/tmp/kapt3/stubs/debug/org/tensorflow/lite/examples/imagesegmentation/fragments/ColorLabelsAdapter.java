package org.tensorflow.lite.examples.imagesegmentation.fragments;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0012B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0007\u001a\u00020\bH\u0016J\u001c\u0010\t\u001a\u00020\n2\n\u0010\u000b\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\f\u001a\u00020\bH\u0016J\u001c\u0010\r\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\bH\u0016J\u0016\u0010\u0011\u001a\u00020\n2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0007R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lorg/tensorflow/lite/examples/imagesegmentation/fragments/ColorLabelsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lorg/tensorflow/lite/examples/imagesegmentation/fragments/ColorLabelsAdapter$ViewHolder;", "()V", "coloredLabels", "", "Lorg/tensorflow/lite/examples/imagesegmentation/OverlayView$ColorLabel;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updateResultLabels", "ViewHolder", "app_debug"})
public final class ColorLabelsAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<org.tensorflow.lite.examples.imagesegmentation.fragments.ColorLabelsAdapter.ViewHolder> {
    private java.util.List<org.tensorflow.lite.examples.imagesegmentation.OverlayView.ColorLabel> coloredLabels;
    
    public ColorLabelsAdapter() {
        super();
    }
    
    @android.annotation.SuppressLint(value = {"NotifyDataSetChanged"})
    public final void updateResultLabels(@org.jetbrains.annotations.NotNull
    java.util.List<org.tensorflow.lite.examples.imagesegmentation.OverlayView.ColorLabel> coloredLabels) {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public org.tensorflow.lite.examples.imagesegmentation.fragments.ColorLabelsAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    org.tensorflow.lite.examples.imagesegmentation.fragments.ColorLabelsAdapter.ViewHolder holder, int position) {
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lorg/tensorflow/lite/examples/imagesegmentation/fragments/ColorLabelsAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lorg/tensorflow/lite/examples/imagesegmentation/databinding/ItemColorLabelsBinding;", "(Lorg/tensorflow/lite/examples/imagesegmentation/fragments/ColorLabelsAdapter;Lorg/tensorflow/lite/examples/imagesegmentation/databinding/ItemColorLabelsBinding;)V", "bind", "", "label", "", "rgbColor", "", "app_debug"})
    public final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private final org.tensorflow.lite.examples.imagesegmentation.databinding.ItemColorLabelsBinding binding = null;
        
        public ViewHolder(@org.jetbrains.annotations.NotNull
        org.tensorflow.lite.examples.imagesegmentation.databinding.ItemColorLabelsBinding binding) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull
        java.lang.String label, int rgbColor) {
        }
    }
}