package com.example.kagazproject.Database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ImageDAO {
    @Insert
    suspend fun insertImage(imageEntity: ImageEntity)

    @Query("Select * From Images")
    fun getAllImages(): LiveData<List<ImageEntity>>

    @Delete
    fun deleteImage(imageEntity: ImageEntity)
}