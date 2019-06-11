package com.siu.deezercomponentfirst.tools.architecture.mvp.view


interface ViewEventBase  {
    fun setLoadMore(loadMore: () -> Unit)
}
