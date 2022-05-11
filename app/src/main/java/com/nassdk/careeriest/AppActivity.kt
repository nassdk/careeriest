package com.nassdk.careeriest

import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.FragmentActivity

class AppActivity : FragmentActivity() {

    private val viewModel: AppViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        AppComponentHolder.component.inject(activity = this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.screen_app)
    }
}