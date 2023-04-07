package com.example.carouselview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CarouselAdapter(private val carouselListData : ArrayList<String>):RecyclerView.Adapter<CarouselAdapter.ViewHolder>() {

    class ViewHolder(itemview : View): RecyclerView.ViewHolder(itemview){
        val text = itemview.findViewById<TextView>(R.id.carouseltext)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.carousel_view,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
       return carouselListData.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
         holder.text.text = carouselListData[position]
    }
}