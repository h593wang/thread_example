package com.palepeak.kotlinexample

import android.R.attr.delay
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class MainActivity : AppCompatActivity() {
    var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Handler().let {
            it.post(object : Runnable {
                override fun run() {
                    counter+=1
                    textView3.text = counter.toString()
                    it.postDelayed(this, 1000)
                }
            })
        }

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = MyAdapter(getData())

    }

    data class ListEntries(val entry1: String, val entry2: String, var switched: Boolean = false)

    fun getData() = fetchDataSlow()

    fun fetchDataSlow(): List<ListEntries> {
        Thread.sleep(5000)

        return listOf(
            ListEntries("Entry 1", "Test"),
            ListEntries("Entry 2", "Test"),
            ListEntries("Entry 3", "Test")
        )
    }
}