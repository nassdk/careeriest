package com.nassdk.careeriest.common.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import com.nassdk.careeriest.ui.theme.StTheme

abstract class BaseScreen : Fragment() {

    @Composable
    abstract fun ScreenContent()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        setupInjection()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        setupInjection()
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = ComposeView(context = requireContext()).apply {

        setViewCompositionStrategy(
            ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed
        )

        setContent(
            content = {
                StTheme(
                    darkTheme = isSystemInDarkTheme(),
                    content = { ScreenContent() }
                )
            }
        )
    }

    protected open fun setupInjection() = Unit
}