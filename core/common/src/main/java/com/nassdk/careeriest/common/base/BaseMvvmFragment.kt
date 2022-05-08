package com.nassdk.careeriest.common.base

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

abstract class BaseMvvmFragment<
        STATE : BaseViewState,
        EVENT : BaseViewEvent,
        COMMAND : BaseVMCommand,
        VM : BaseViewModel<STATE, EVENT, COMMAND>
        > : BaseFragment() {

    abstract val viewModel: VM

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(
                state = Lifecycle.State.STARTED,
                block = {
                    viewModel.viewState.onEach(::handleState)
                    viewModel.commands.onEach(::handleCommand)
                }
            )
        }
    }

    protected open fun handleState(state: STATE) = Unit
    protected open fun handleCommand(command: COMMAND) = Unit

    protected fun performEvent(event: EVENT) {
        viewModel.performViewEvent(event = event)
    }
}