package com.example.laba_kotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val imageV: ImageView = itemView.findViewById(R.id.pizza_image)
    val nameV: TextView = itemView.findViewById(R.id.pizza_name)
    val weightV: TextView = itemView.findViewById(R.id.pizza_weight)
    val sizeV: TextView = itemView.findViewById(R.id.pizza_size)
    val priceV: TextView = itemView.findViewById(R.id.pizza_price)
}

class CustomAdapter(private val items: ArrayList<Pizza>) : RecyclerView.Adapter<CustomHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.pizza_item, parent, false)
        return CustomHolder(view)
    }

    override fun onBindViewHolder(holder: CustomHolder, position: Int) {
        val pizza = items[position]
        holder.imageV.setImageResource(pizza.image)
        holder.nameV.text = pizza.name
        holder.weightV.text = pizza.weight
        holder.sizeV.text = pizza.size
        holder.priceV.text = pizza.price
    }

    override fun getItemCount(): Int = items.size
}