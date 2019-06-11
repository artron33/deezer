package com.siu.deezercomponentfirst.app.home.album.pane.presenter

import com.siu.deezercomponentfirst.domain.repository.feed.response.Album
import com.siu.deezercomponentfirst.tools.architecture.mvp.presenter.PresenterBase
import com.siu.deezercomponentfirst.tools.architecture.mvp.view.ViewBase


interface AlbumPresenterInterface : PresenterBase<Album?>

class AlbumPresenter(
    val albumView: ViewBase<Album>

) : AlbumPresenterInterface {

    override fun render(album: Album?) {
        album?.let { showFeed(album) }
    }

    private fun showFeed(album: Album) {
        albumView.show(album)
    }

}
