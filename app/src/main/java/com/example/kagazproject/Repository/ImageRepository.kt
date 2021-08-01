package com.example.kagazproject.Repository

import android.content.Context
import com.example.kagazproject.Database.ImageDatabase
import com.example.kagazproject.Database.ImageEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ImageRepository {
    fun insertImageToDataBase(imagePath: String, context: Context) {
        CoroutineScope(Dispatchers.IO).launch {
            val imageEntity = ImageEntity(0, imageUrl = imagePath)
            ImageDatabase.getInstance(context)?.imageDAO?.insertImage(imageEntity)
        }
    }
}