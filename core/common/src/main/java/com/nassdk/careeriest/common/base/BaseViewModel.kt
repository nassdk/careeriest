package com.nassdk.careeriest.common.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

abstract class BaseViewModel<
        STATE : BaseViewState,
        EVENT : BaseViewEvent,
        COMMAND : BaseVMCommand> : ViewModel() {

    protected abstract val initialState: STATE

    private val _viewState by lazy {
        MutableStateFlow(initialState)
    }

    private val viewEventsSharedFlow = MutableSharedFlow<EVENT>(
        replay = 1,
        onBufferOverflow = BufferOverflow.DROP_OLDEST
    )

    private val _commands = MutableSharedFlow<COMMAND>(
        replay = 1,
        onBufferOverflow = BufferOverflow.DROP_OLDEST
    )

    init {
        viewEventsSharedFlow.onEach(::handleViewEvent).launchIn(viewModelScope)
    }

    val commands: SharedFlow<COMMAND>
        get() = _commands

    val viewState: StateFlow<STATE>
        get() = _viewState

    val viewStateData: STATE
        get() = _viewState.value

    fun performViewEvent(event: EVENT) {
        viewEventsSharedFlow.tryEmit(value = event)
    }

    protected open fun handleViewEvent(event: EVENT) = Unit

    protected fun sendCommand(command: COMMAND) {
        _commands.tryEmit(value = command)
    }
}