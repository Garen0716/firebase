package com.example.breads_1.Viewpager

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.firebase.R

class VPAdapter(private val viewPagerItemArrayList: ArrayList<ViewPagerItem>) :
    RecyclerView.Adapter<VPAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_view_pager_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val viewPagerItem = viewPagerItemArrayList[position]

        holder.imageView.setImageResource(viewPagerItem.imageID)
        holder.tcHeading.text = viewPagerItem.heading
        holder.tvDesc.text = viewPagerItem.description
    }

    override fun getItemCount(): Int {
        return viewPagerItemArrayList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.ivimage)
        val tcHeading: TextView = itemView.findViewById(R.id.tvHeading)
        val tvDesc: TextView = itemView.findViewById(R.id.tvDesc)
    }
}
