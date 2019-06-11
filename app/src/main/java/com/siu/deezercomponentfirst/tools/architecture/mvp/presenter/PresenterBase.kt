package com.siu.deezercomponentfirst.tools.architecture.mvp.presenter

interface PresenterBase<T> {
    fun render(state: T)

}
