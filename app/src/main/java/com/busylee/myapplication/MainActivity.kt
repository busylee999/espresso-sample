package com.busylee.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val text = findViewById<EditText>(R.id.et_text)
        findViewById<View>(R.id.btn_action).setOnClickListener {
            startActivity(
                Intent(this, SuggestActivity::class.java).apply {
                    putExtra(ResultActivity.EXT_TEXT, text.text.toString())
                }
            )
        }
    }
}
