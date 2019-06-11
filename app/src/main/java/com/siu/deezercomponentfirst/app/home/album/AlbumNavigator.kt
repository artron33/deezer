package com.siu.deezercomponentfirst.app.home.album

import android.os.Build
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.transition.Fade
import com.siu.deezercomponentfirst.R
import com.siu.deezercomponentfirst.app.home.navigator.ParentNavigator



interface AlbumNavigator : ParentNavigator {

    companion object {
        const val TAG = "ALBUM_TAG"
    }

    fun displayAlbum (
        context: AppCompatActivity,
        albumId: Int,
        backgroundColor: Int,
        sharedElementDeezer: View,
        sharedElementTitle: View,
        sharedElementImg: View,
        sharedElementColor: View
    ) {
        val album = AlbumFragment.newInstance(
            albumId,
            backgroundColor,
            ViewCompat.getTransitionName(sharedElementDeezer)!!,
            ViewCompat.getTransitionName(sharedElementTitle)!!,
            ViewCompat.getTransitionName(sharedElementImg)!!,
            ViewCompat.getTransitionName(sharedElementColor)!!
        )

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val anim = animationTransitionGeneric(context)

            album.sharedElementEnterTransition = anim
            album.enterTransition =  Fade()

            album.sharedElementReturnTransition = anim
            album.exitTransition =   Fade()
        }
        val fragmentTransaction = context.supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.container, album)

        fragmentTransaction.addSharedElement(sharedElementColor, ViewCompat.getTransitionName(sharedElementColor)!!)
        fragmentTransaction.addSharedElement(sharedElementTitle, ViewCompat.getTransitionName(sharedElementTitle)!!)
        fragmentTransaction.addSharedElement(sharedElementImg, ViewCompat.getTransitionName(sharedElementImg)!!)
        fragmentTransaction.addSharedElement(sharedElementDeezer, ViewCompat.getTransitionName(sharedElementDeezer)!!)

        fragmentTransaction.addToBackStack(TAG)
        fragmentTransaction.commit()
    }

    fun removeAlbum (
        context: AppCompatActivity

    ) {
        val manager = context.supportFragmentManager
        manager.popBackStack()
    }
}
