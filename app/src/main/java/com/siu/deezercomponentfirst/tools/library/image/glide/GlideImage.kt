package com.siu.deezercomponentfirst.tools.library.image.glide

import android.content.Context
import android.net.Uri
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.siu.deezercomponentfirst.R

object GlideImage {

    fun load(context: Context, width: Int, height: Int, url: String,
             imageView: ImageView
    ) {
        val uri: Uri = Uri.parse(url)
        Glide.with(context)
            .load(uri)
            .override(width, height)
            .error(R.drawable.placeholder_album) // will be displayed if the image cannot be loaded
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(imageView)

    }

    fun loadAfterTransition(context: Context, width: Int, height: Int, url: String,
             imageView: ImageView
    ) {
        val uri: Uri = Uri.parse(url)
        Glide.with(context)
            .load(uri)
            .override(width, height)
            .dontAnimate()
            .into(imageView)
    }
}
