package com.siu.deezercomponentfirst.app.home.loader.pane

import android.content.Context
import android.util.AttributeSet
import com.siu.deezercomponentfirst.R
import com.siu.deezercomponentfirst.app.custom.generic.GenericPane


class LoaderPane @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : GenericPane(context, attrs, defStyleAttr) {

    override fun onCreate() {
    }

    override fun onStart() {
    }

    override fun onStop() {
    }


    init {
        inflate(context, R.layout.pane_loader,  this)
    }

}
