package com.example.roomexample.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.roomexample.dao.SampleDao
import com.example.roomexample.entity.SampleEntity

@Database(entities = [SampleEntity::class], version = 1, exportSchema = false)
abstract class SampleDatabase: RoomDatabase() {
    abstract fun sampleDao(): SampleDao

    companion object {
        @Volatile
        private var INSTANCE: SampleDatabase? = null

        fun getInstance(context: Context): SampleDatabase{
            synchronized(this){
                return INSTANCE?: Room.databaseBuilder(
                    context.applicationContext,
                    SampleDatabase::class.java,
                    "sample_database"
                ).build().also{
                    INSTANCE = it
                }
            }
        }
    }
}