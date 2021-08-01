package com.example.kagazproject.ViewModel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.kagazproject.ViewHolder.ImageViewModel

class ImageViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ImageViewModel::class.java)) {
            return ImageViewModel(context) as T
        }
        throw IllegalArgumentException("Unknown")
    }
}