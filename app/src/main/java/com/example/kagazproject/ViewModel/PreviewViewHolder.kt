package com.example.kagazproject.ViewModel

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.kagazproject.Database.ImageEntity

class PreviewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun setData(image: ImageEntity) {
        itemView.apply {
           // ivPreviewImg.setImageResource(image.imgId)= image.imageUrl
        }
    }
}