package com.siu.deezercomponentfirst.app.home.feed

import android.os.Build
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.transition.Explode
import com.siu.deezercomponentfirst.R
import com.siu.deezercomponentfirst.app.home.navigator.ParentNavigator

interface FeedNavigator : ParentNavigator {

    fun displayFeed (
        context: AppCompatActivity,
        sharedElement: View
    ) {

        val feeds = FeedFragment.newInstance()

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val anim = animationTransitionGeneric(context)
            feeds.sharedElementEnterTransition = anim
            feeds.enterTransition = Explode()
            feeds.sharedElementReturnTransition = anim
            feeds.exitTransition =  Explode()
        }

        context.supportFragmentManager
            .beginTransaction()
            .addSharedElement(sharedElement, ViewCompat.getTransitionName(sharedElement)!!)
            .replace(R.id.container, feeds)
            .commit()
    }

}
