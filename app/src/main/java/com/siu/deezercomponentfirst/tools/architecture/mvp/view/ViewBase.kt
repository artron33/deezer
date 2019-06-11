package com.siu.deezercomponentfirst.tools.architecture.mvp.view


interface ViewBase<T> {
    fun showLoadingError()
    fun showNos()
    fun show(data: T)

}