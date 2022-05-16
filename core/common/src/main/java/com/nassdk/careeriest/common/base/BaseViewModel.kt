package com.nassdk.careeriest.common.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nassdk.careeriest.common.coroutines.CoroutinesDispatcherProvider
import com.nassdk.careeriest.common.coroutines.error.CoroutineErrorHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

abstract class BaseViewModel<
        STATE : BaseScreenState,
        EVENT : BaseScreenEvent,
        COMMAND : BaseVMCommand>(
    private val dispatcherProvider: CoroutinesDispatcherProvider = CoroutinesDispatcherProvider()
) : ViewModel() {

    protected abstract val initialState: STATE

    protected val _viewState by lazy {
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

    protected fun launchCoroutine(
        body: suspend CoroutineScope.() -> Unit,
    ): Job = viewModelScope.launch(
        context = CoroutineErrorHandler(),
        block = {
            body()
        }
    )

    protected fun launchIOCoroutine(
        body: suspend CoroutineScope.() -> Unit,
    ): Job = launchCoroutine {
        withContext(dispatcherProvider.io) {
            body()
        }
    }
}