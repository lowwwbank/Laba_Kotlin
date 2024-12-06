package com.example.laba_kotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.io.IOException

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pizzaList = ArrayList<Pizza>()
        val refImages = arrayOf(R.drawable.a, R.drawable.b, R.drawable.c,
            R.drawable.d, R.drawable.e, R.drawable.f, R.drawable.g, R.drawable.h,
            R.drawable.i, R.drawable.j, R.drawable.k, R.drawable.l, R.drawable.m
        )

        try {
            assets.open("pizza.txt").bufferedReader().use { reader ->
                var idx = 0
                reader.forEachLine { curLine ->
                    val tokens = curLine.split("\\s+".toRegex())
                    val name = tokens[0].replace('_', ' ')
                    val weight = "${tokens[1]} г"
                    val size = "${tokens[2]} см"
                    val price = "${tokens[3]} ₽"
                    pizzaList.add(Pizza(name, weight, size, price, refImages[idx++]))
                }
            }
        } catch (error: IOException) {
            throw RuntimeException("Error displaying information", error)
        }

        val recyclerView: RecyclerView = findViewById(R.id.rc_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = CustomAdapter(pizzaList)
    }
}