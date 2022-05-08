package com.nassdk.careeriest

import android.os.Bundle
import androidx.fragment.app.FragmentActivity

class AppActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.screen_app)
    }
}