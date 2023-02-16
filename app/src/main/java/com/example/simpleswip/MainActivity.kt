package com.example.simpleswip

import android.icu.lang.UCharacter.VerticalOrientation
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.VERTICAL
import com.example.simpleswip.adapter.TimesAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var times = arrayOf("12:00","01:00","02:00","03:00","04:00","05:00","06:00")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setAdapter(times);


    }

    private fun setAdapter(times: Array<String>) {
        var adapter = TimesAdapter(this@MainActivity,times)
        var lm = LinearLayoutManager(this@MainActivity,VERTICAL, false)
        rvView.layoutManager = lm
        rvView.adapter = adapter

    }
}