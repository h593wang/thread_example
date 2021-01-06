package com.palepeak.kotlinexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class Template : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val data: List<Int?> = listOf<Int?>(1,2,3,null,4)

        //textView.text = processData(data).toString()
    }

    fun processData(data: List<Int?>): List<Int?> {
        val result: MutableList<Int?> = mutableListOf<Int?>()
        for (item in data) {
            if (item == null) result.add(item)
            else result.add(item+1)
        }

        return result
    }
}