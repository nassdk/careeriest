package com.nassdk.careeriest.common.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.nassdk.careeriest.common.extensions.collect
import com.nassdk.careeriest.ui.theme.StTheme

abstract class BaseVmScreen<
        STATE : BaseScreenState,
        EVENT : BaseScreenEvent,
        COMMAND : BaseVMCommand
        > : Fragment() {

    abstract val viewModel: BaseViewModel<STATE, EVENT, COMMAND>

    @Composable
    abstract fun ScreenContent(screenState: State<STATE>)

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
                    content = { ScreenContent(screenState = viewModel.screenState.collectAsState()) }
                )
            }
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.commands.flowWithLifecycle(lifecycle = lifecycle).collect(::handleVmCommand)
        }
    }

    protected fun performEvent(event: EVENT) {
        viewModel.performViewEvent(event = event)
    }

    protected open fun setupInjection() = Unit
    protected open fun handleVmCommand(command: COMMAND) = Unit
}