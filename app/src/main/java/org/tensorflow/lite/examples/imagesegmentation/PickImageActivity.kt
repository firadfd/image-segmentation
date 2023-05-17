package org.tensorflow.lite.examples.imagesegmentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class PickImageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pick_image)
    }
}