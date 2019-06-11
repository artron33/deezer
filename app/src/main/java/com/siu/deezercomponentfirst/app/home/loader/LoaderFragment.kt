package com.siu.deezercomponentfirst.app.home.loader

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.siu.deezercomponentfirst.app.home.loader.pane.LoaderPane
import com.siu.deezercomponentfirst.app.home.navigator.MainNavigator
import kotlinx.android.synthetic.main.pane_loader.*
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

/**
 * Main UI for the statistics screen.
 */
class LoaderFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return LoaderPane(context!!)//inflater.inflate(R.layout.pane_loader, container, false)
    }

    override fun onStart() {
        super.onStart()
        worker.schedule(task, 2, TimeUnit.SECONDS)
    }

    override fun onStop() {
        super.onStop()
        worker?.shutdownNow()
    }

    private val worker = Executors.newSingleThreadScheduledExecutor()
    private val task = Runnable {
        MainNavigator.displayFeed(
            activity as AppCompatActivity,
            deezer_icon
        )
    }

    companion object {
        fun newInstance(): LoaderFragment {
            return LoaderFragment()
        }
    }
}
