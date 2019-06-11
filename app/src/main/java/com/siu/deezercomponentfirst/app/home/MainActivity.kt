package com.siu.deezercomponentfirst.app.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.siu.deezercomponentfirst.R
import com.siu.deezercomponentfirst.app.home.navigator.MainNavigator

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            MainNavigator.displayLoader(this)
        }
    }
}
