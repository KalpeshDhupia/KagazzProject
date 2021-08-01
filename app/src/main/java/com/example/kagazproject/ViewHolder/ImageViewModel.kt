package com.example.kagazproject.ViewHolder

import android.content.Context
import androidx.lifecycle.ViewModel

class ImageViewModel(private val context: Context) :
    ViewModel() {

    fun insertDataToDatabase(imagePath: String) {
        insertImageToDataBase(imagePath, context)
    }

    private fun insertImageToDataBase(imagePath: String, context: Context) {

    }
}