package com.example.kagazproject.Database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Images")
data class ImageEntity(
    @PrimaryKey(autoGenerate = true)
    var imgId: Int = 0,
    @ColumnInfo(name = "imagePath")
    val imageUrl: String

)