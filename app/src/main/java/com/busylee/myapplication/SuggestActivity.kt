package com.busylee.myapplication

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SuggestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_suggest)
        val stringExtra = intent.getStringExtra(EXT_TEXT)!!
        val adapter = Adapter(
            this,
            listOf(stringExtra, stringExtra.plus("1"), stringExtra.plus("2"), stringExtra.plus("3")),
            clickListener = object : ViewHolder.ClickListener {
                override fun onClick(value: String) {
                    startActivity(
                        Intent(
                            this@SuggestActivity,
                            ResultActivity::class.java).apply {
                            putExtra(ResultActivity.EXT_TEXT, value)
                        }
                    )
                }
            }
        )
        findViewById<RecyclerView>(R.id.recyclerView).apply {
            layoutManager = LinearLayoutManager(
                this@SuggestActivity, LinearLayoutManager.VERTICAL, false
            )
            this.adapter = adapter
        }
    }

    class ViewHolder(
        view: View,
        clickListener: ClickListener
    ) : RecyclerView.ViewHolder(view) {

        private val textView: TextView = view.findViewById(R.id.tv_value)
        private lateinit var value: String
        init {
            view.setOnClickListener {
                clickListener.onClick(value)
            }
        }

        fun bind(value: String) {
            this.value = value
            textView.text = value
        }

        interface ClickListener {
            fun onClick(value: String)
        }
    }

    class Adapter(
        private val context: Context,
        private val list: List<String>,
        private val clickListener: ViewHolder.ClickListener
    ) : RecyclerView.Adapter<ViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            ViewHolder(
                LayoutInflater.from(context).inflate(R.layout.item_string, parent, false),
                clickListener
            )

        override fun getItemCount() = list.size

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.bind(list[position])
        }

    }

    companion object {
        const val EXT_TEXT = "EXT_TEXT"
    }
}