package com.juniar.ancodev.infomovie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("", "irfan homo sekali")
        Log.d("ini tagnya", "irfan sangat homo sekali")

        val array = arrayOf(10, 20, 20, 10, 10, 30, 50, 10, 20)
        val newArray = array.distinct()
        var pair = 0
        newArray.forEach {
            val value = it
            pair += array.count { it == value } / 2
        }
        println(pair.toString())
    }
}
