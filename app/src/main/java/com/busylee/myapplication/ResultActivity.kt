package com.busylee.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val stringExtra = intent.getStringExtra(EXT_TEXT)!!
        if (stringExtra.contains('3')) {
            findViewById<TextView>(R.id.tv_text).text = "Error"
        } else {
            findViewById<TextView>(R.id.tv_text).text = "Success"
        }

    }

    companion object {
        const val EXT_TEXT = "EXT_TEXT"
    }
}