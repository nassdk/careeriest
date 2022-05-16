package com.nassdk.careeriest.common.base

abstract class BaseMvvmFragment<
        STATE : BaseScreenState,
        EVENT : BaseScreenEvent,
        COMMAND : BaseVMCommand,
        VM : BaseViewModel<STATE, EVENT, COMMAND>
        > : BaseFragment() {

    abstract val viewModel: VM

    protected fun performEvent(event: EVENT) {
        viewModel.performViewEvent(event = event)
    }
}