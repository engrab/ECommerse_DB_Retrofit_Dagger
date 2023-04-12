package com.example.ecommersedemo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.ecommersedemo.models.Product

class MainAdapter(private val list: List<Product>):RecyclerView.Adapter<MainAdapter.MyViewHolder>() {


    class MyViewHolder(view:View):RecyclerView.ViewHolder(view) {

        val image:ImageView = view.findViewById(R.id.image)
        val title:TextView = view.findViewById(R.id.title)
        val price:TextView = view.findViewById(R.id.price)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
       return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_item, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = list.get(position)
        holder.image.load(item.image)
        holder.title.text = item.title
        holder.price.text = item.price.toString()
    }

    override fun getItemCount(): Int {
       return list.size
    }
}