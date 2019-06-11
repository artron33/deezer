package com.siu.deezercomponentfirst.app.home.loader

import androidx.appcompat.app.AppCompatActivity
import com.siu.deezercomponentfirst.R
import com.siu.deezercomponentfirst.app.home.navigator.ParentNavigator

interface LoaderNavigator : ParentNavigator {
    fun displayLoader (
        context: AppCompatActivity
    ) {
        context.supportFragmentManager
            .beginTransaction()
            .add(R.id.container, LoaderFragment.newInstance())
            .commit()
    }
}
