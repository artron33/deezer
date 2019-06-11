package com.siu.deezercomponentfirst.app.home.album.pane.view

import androidx.appcompat.app.AppCompatActivity
import com.siu.deezercomponentfirst.app.home.album.pane.AlbumPane
import com.siu.deezercomponentfirst.app.home.navigator.MainNavigator
import com.siu.deezercomponentfirst.domain.repository.feed.response.Album
import com.siu.deezercomponentfirst.tools.architecture.mvp.view.ViewBase
import com.siu.deezercomponentfirst.tools.library.image.glide.GlideImage
import kotlinx.android.synthetic.main.pane_album.view.*
import java.lang.ref.WeakReference


class AlbumView(
    val albumPane: AlbumPane,
    weakActivity: WeakReference<AppCompatActivity>,
    albumColor: Int,
    transitionDeezer: String,
    transitionTitle: String,
    transitionImg: String,
    transitionColor: String

) : ViewBase<Album> {

    override fun showLoadingError() {
        //todo: Handle properly
    }

    override fun showNos() {
        //todo: Handle properly
    }

    override fun show(data: Album) {
        GlideImage.loadAfterTransition(
            albumPane.context,
            albumPane.album_img.width,
            albumPane.album_img.height,
            data.cover_medium,
            albumPane.album_img
        )
        albumPane.album_title.text = data.title

    }

    init {
        albumPane.album_title.transitionName        = transitionTitle
        albumPane.album_img.transitionName          = transitionImg
        albumPane.album_color.transitionName        = transitionColor
        albumPane.album_deezer_icon.transitionName  = transitionDeezer
        albumPane.album_color.setBackgroundColor(albumColor)
        albumPane.album_color.elevation = 0.0f
        albumPane.album_deezer_icon.elevation = 16.0f

        albumPane.album_deezer_icon.setOnClickListener {
            weakActivity.get()?.let {
                    activity ->
                MainNavigator.removeAlbum(activity)
            }
        }

    }

}
