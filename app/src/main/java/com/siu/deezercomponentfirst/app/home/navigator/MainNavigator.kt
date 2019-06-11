package com.siu.deezercomponentfirst.app.home.navigator

import android.content.Context
import androidx.transition.Transition
import androidx.transition.TransitionInflater
import com.siu.deezercomponentfirst.R
import com.siu.deezercomponentfirst.app.home.album.AlbumNavigator
import com.siu.deezercomponentfirst.app.home.feed.FeedNavigator
import com.siu.deezercomponentfirst.app.home.loader.LoaderNavigator


interface ParentNavigator {
    fun animationTransitionGeneric(context: Context) : Transition
}

object MainNavigator : LoaderNavigator, FeedNavigator, AlbumNavigator {

    override fun animationTransitionGeneric(context: Context) =
        TransitionInflater
            .from(context)
            .inflateTransition(R.transition.transition_generics)


}
