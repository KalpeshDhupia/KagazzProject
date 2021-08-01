package com.example.kagazproject.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kagazproject.Database.ImageEntity
import com.example.kagazproject.R
import com.example.kagazproject.ViewModel.PreviewViewHolder

class PreviewAdapter(private var imageList: List<ImageEntity>) :
    RecyclerView.Adapter<PreviewViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PreviewViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.preview_item_layout, parent, false)
        return PreviewViewHolder(view)
    }

    override fun onBindViewHolder(holder: PreviewViewHolder, position: Int) {
        val image = imageList[position]
        holder.setData(image)
    }

    override fun getItemCount(): Int {
        return imageList.size
    }

    fun updateData(imageList: List<ImageEntity>) {
        this.imageList = imageList
        notifyDataSetChanged()
    }

}