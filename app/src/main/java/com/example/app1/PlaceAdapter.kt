package com.example.app1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView

class PlaceAdapter(val placeList:ArrayList<Place>): RecyclerView.Adapter<PlaceAdapter.PlaceViewHolder>(){

    inner class PlaceViewHolder(view: View):RecyclerView.ViewHolder(view) {
        val name=itemView.findViewById<TextView>(R.id.name)
        val desc = itemView.findViewById<TextView>(R.id.description)
        val pro=itemView.findViewById<TextView>(R.id.province)
        val img = itemView.findViewById<ImageView>(R.id.avatar)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaceViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.item_place,parent,false)
        val holder = PlaceViewHolder(view)
        return  holder
    }

    override fun onBindViewHolder(holder:PlaceViewHolder, position: Int) {
        val place = placeList[position]
        holder.name.text=place.name
        holder.desc.text=place.description
        holder.img.setImageResource(place.avatar)
        holder.pro.text=place.province
    }

    override fun getItemCount(): Int {
        return placeList.size
    }

}