package com.busylee.myapplication

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val stringExtra = intent.getStringExtra(EXT_TEXT)
        findViewById<TextView>(R.id.tv_text).text = stringExtra
    }

    companion object {
        const val EXT_TEXT = "EXT_TEXT"
    }
}