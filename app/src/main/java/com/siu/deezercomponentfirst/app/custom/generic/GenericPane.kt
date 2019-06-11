package com.siu.deezercomponentfirst.app.custom.generic

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout

/**
 * Ceci est une très vielle classe à moi.
 * Copié sur un tuto de Square qui explique pourquoi il
 * vaut mieux ne pas avoir de fragment dans un projet !
 */
abstract class GenericPane @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {
    var hasBeenCreated = false

    var hasStarted = false

    override fun onFinishInflate() {
        super.onFinishInflate()
        onCreatePane()
    }
    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        onCreatePane()
    }

    fun onCreatePane() {
         if (hasBeenCreated == false) {
             hasBeenCreated = true
             onCreate()
         }
    }
    abstract fun onCreate()

    //onStart Part
    override fun onVisibilityChanged(changedView: View, visibility: Int) {
        super.onVisibilityChanged(changedView, visibility)

        //to get the hasStart
        if (visibility == View.VISIBLE && hasStarted == false) {
            hasStarted = true
            onStart()
        } else if ((visibility == View.INVISIBLE ||visibility == View.GONE) && hasStarted == true) {
            hasStarted = false
            onStop()
        }
    }

    abstract fun onStart()

    abstract fun onStop()

    init {
//        this.layoutParams = LayoutParams(MarginLayoutParams.MATCH_PARENT, MarginLayoutParams.MATCH_PARENT)

        //android:animateLayoutChanges="true" programmatically
//        layoutTransition = LayoutTransition()
        clipToPadding = false
    }

}

