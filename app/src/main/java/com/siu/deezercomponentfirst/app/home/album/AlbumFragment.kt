package com.siu.deezercomponentfirst.app.home.album

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.siu.deezercomponentfirst.app.home.album.pane.AlbumPane

/**
 * Main UI for the statistics screen.
 */
class AlbumFragment : Fragment() {
    var viewPane: View? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val bundle = this.arguments
        bundle?.let {
            val albumId             = bundle.getInt(ALBUM_KEY, DEFAULT_ALBUM)
            val albumColor          = bundle.getInt(ALBUM_COLOR_KEY, DEFAULT_ALBUM)
            val transitionDeezer    = bundle.getString(DEEZER)
            val transitionTitle     = bundle.getString(TITLE)
            val transitionImg       = bundle.getString(IMG)
            val transitionColor     = bundle.getString(ALBUM_COLOR)

            viewPane = viewPane?: AlbumPane(context!!,
                    albumId = albumId,
                    albumColor = albumColor,
                    transitionDeezer= transitionDeezer,
                    transitionTitle = transitionTitle,
                    transitionImg = transitionImg,
                    transitionColor = transitionColor,
                    activity = activity as AppCompatActivity
                )
            return viewPane
        }
        return null
    }

    companion object {
        const val ALBUM_KEY = "KEY_ALBUM"
        const val ALBUM_COLOR_KEY = "KEY_COLOR"
        const val ALBUM_COLOR = "COLOR"
        const val DEEZER = "DEEZER"
        const val TITLE = "TITLE"
        const val IMG= "IMG"
        const val DEFAULT_ALBUM = 0

        fun newInstance(
            albumId: Int,
            albumColor: Int,
            transitionNameDeezer: String,
            transitionNameTitle: String,
            transitionNameImg: String,
            sharedElementColor: String
        ): AlbumFragment {

            val fragment = AlbumFragment()
            val bundle = Bundle()

            bundle.putInt(ALBUM_KEY, albumId)
            bundle.putInt(ALBUM_COLOR_KEY, albumColor)
            bundle.putString(DEEZER, transitionNameDeezer)
            bundle.putString(TITLE, transitionNameTitle)
            bundle.putString(IMG, transitionNameImg)
            bundle.putString(ALBUM_COLOR, sharedElementColor)

            fragment.arguments = bundle
            return fragment
        }
    }

}
