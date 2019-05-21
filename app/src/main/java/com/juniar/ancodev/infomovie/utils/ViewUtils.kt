package com.juniar.ancodev.infomovie.utils

import android.util.Log
import android.view.ViewTreeObserver
import android.widget.TextView
import kotlinx.coroutines.CompletableDeferred

suspend fun TextView.getCountLine(): Int {
    val thisTextView = this
    val lineCount = CompletableDeferred<Int>()
    this.viewTreeObserver.addOnPreDrawListener(object : ViewTreeObserver.OnPreDrawListener {
        override fun onPreDraw(): Boolean {
            thisTextView.viewTreeObserver.removeOnPreDrawListener(this)
            lineCount.complete(thisTextView.lineCount)
            Log.d("line count dari utils 1", lineCount.toString())
            return true
        }
    })
    Log.d("line count dari utils 2", lineCount.toString())
    return lineCount.await()
}