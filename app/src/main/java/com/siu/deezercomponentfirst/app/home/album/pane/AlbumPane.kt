package com.siu.deezercomponentfirst.app.home.album.pane

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.app.AppCompatActivity
import com.siu.deezer.injection.Injection
import com.siu.deezercomponentfirst.R
import com.siu.deezercomponentfirst.app.custom.generic.GenericPane
import com.siu.deezercomponentfirst.app.home.album.pane.presenter.AlbumPresenter
import com.siu.deezercomponentfirst.app.home.album.pane.usecase.AlbumUseCase
import com.siu.deezercomponentfirst.app.home.album.pane.view.AlbumView
import java.lang.ref.WeakReference


class AlbumPane @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    activity: AppCompatActivity,
    albumId: Int = 0,
    albumColor: Int = 0,
    transitionDeezer: String = "",
    transitionTitle: String = "",
    transitionImg: String = "",
    transitionColor: String = ""

) : GenericPane(context, attrs, defStyleAttr) {
    val albumView by lazy {
        AlbumView (this,
            WeakReference(activity),
            albumColor,
            transitionDeezer,
            transitionTitle,
            transitionImg,
            transitionColor
        )
    }

    val mockKustomPresenter by lazy {
        AlbumUseCase(
            Injection.provideFeedsRepository(),
            Injection.provideSchedulerProvider(),
            AlbumPresenter(
                 albumView
            ),
            albumId,
            "2529"

        )
    }

    override fun onCreate() {
    }

    override fun onStart() {
    }

    override fun onStop() {
    }


    init {
        inflate(context, R.layout.pane_album,  this)
        mockKustomPresenter.init()

        clipToPadding = false
        clipChildren = false
    }

}
