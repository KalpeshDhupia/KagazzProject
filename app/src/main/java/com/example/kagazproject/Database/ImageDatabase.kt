package com.example.kagazproject.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [ImageEntity::class],
    views = [ImageEntity::class],
    version = 1,
    exportSchema = false
)
abstract class ImageDatabase : RoomDatabase() {
    abstract val imageDAO: ImageDAO

    companion object {
        private var INSTANCE: ImageDatabase? = null
        fun getInstance(context: Context): ImageDatabase? {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null)
                    instance = Room.databaseBuilder(context, ImageDatabase::class.java,"image_DB").build()
                INSTANCE = instance
            }
return INSTANCE
        }
    }

}