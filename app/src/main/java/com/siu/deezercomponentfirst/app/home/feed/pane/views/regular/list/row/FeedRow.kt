package com.siu.deezercomponentfirst.app.home.feed.pane.views.regular.list.row

import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.util.AttributeSet
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.siu.deezercomponentfirst.R
import com.siu.deezercomponentfirst.app.home.feed.pane.views.regular.list.adapter.FeedAdapter
import com.siu.deezercomponentfirst.app.home.navigator.MainNavigator
import com.siu.deezercomponentfirst.tools.library.image.glide.GlideImage
import kotlinx.android.synthetic.main.feed_row.view.*
import java.lang.ref.WeakReference


class FeedRow @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    parent : ViewGroup

) : ConstraintLayout(context, attrs, defStyleAttr) {

    fun bindPage(
        weakActivity: WeakReference<AppCompatActivity>,
        rowViewModel: FeedAdapter.FeedRowViewModel
        ) {
        album_title?.let {
            it.text =
                """${rowViewModel.album.title}
                  |${rowViewModel.album.artist?.name_artist}""".trimMargin()
            it.transitionName = album_img.resources.getString(R.string.transitionname_album_title) + rowViewModel.album.id
        }

        album_img?.let {
            it.transitionName   = album_img.resources.getString(R.string.transitionname_album_img)+ rowViewModel.album.id
            GlideImage.load(it.context, it.width, it.height, rowViewModel.album.cover_big, it)
        }

        album_color?.let {
            it.transitionName   = album_color.resources.getString(R.string.transitionname_album_color)+ rowViewModel.album.id
            val color = getColor(rowViewModel.position )
            it.setBackgroundResource(color)
        }

        this.setOnClickListener {
            weakActivity.get()?.let {
                MainNavigator.displayAlbum(
                    it,
                    rowViewModel.album.id,
                    getBackgroundColor(album_color),
                    rowViewModel.deezerIcon,
                    album_title,
                    album_img,
                    album_color)
            }
        }

    }

    private fun getColor(position : Int)
        = when (position % (7)) {
            0 -> R.color.validation
            1 -> R.color.warning
            2 -> R.color.accent
            4 -> R.color.primary
            5 -> R.color.purple_light
            6 -> R.color.ui_level350
            7 -> R.color.error
            else -> R.color.error
        }


    private fun getBackgroundColor(view : View): Int {
        return (view.background as? ColorDrawable)?.color ?: 0
    }

    init {
        LayoutInflater.from(context).inflate(R.layout.feed_row, this, true)


        //because of merge attribute
        val outValue = TypedValue()
        context.theme.resolveAttribute(
            android.R.attr.selectableItemBackground, outValue, true
        )
        foreground = resources.getDrawable(outValue.resourceId, context.theme)
    }
}
