package com.example.roomexample.repository

import androidx.lifecycle.LiveData
import com.example.roomexample.dao.SampleDao
import com.example.roomexample.entity.SampleEntity

class SampleRepository (private val sampleDao: SampleDao){
    val readAllData: LiveData<List<SampleEntity>> = sampleDao.getAllData()

    suspend fun addSample(item: List<SampleEntity>){
        sampleDao.insert(item)
    }

    suspend fun updateSample(item: SampleEntity){
        sampleDao.update(item)
    }

    suspend fun deleteSample(item: SampleEntity){
        sampleDao.delete(item)
    }

    suspend fun deleteAllRecords(){
        sampleDao.deleteAllRecords()
    }
}