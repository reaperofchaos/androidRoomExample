package com.example.roomexample.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.example.roomexample.database.SampleDatabase
import com.example.roomexample.entity.SampleEntity
import com.example.roomexample.repository.SampleRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class SampleViewModel(application: Application): AndroidViewModel(application) {
    private val readAllData: LiveData<List<SampleEntity>>
    private val repository: SampleRepository

    init{
        val sampleDao = SampleDatabase.getInstance(application).sampleDao()
        repository = SampleRepository(sampleDao = sampleDao)
        readAllData = repository.readAllData
    }

    fun addSample(item: List<SampleEntity>)
    {
        viewModelScope.launch(Dispatchers.IO){
            repository.addSample(item = item)
        }
    }

    fun updateSample(item: SampleEntity)
    {
        viewModelScope.launch(Dispatchers.IO){
            repository.updateSample(item = item)
        }
    }

    fun deleteSample(item: SampleEntity)
    {
        viewModelScope.launch(Dispatchers.IO){
            repository.deleteSample(item = item)
        }
    }

    fun deleteAllRecords()
    {
        viewModelScope.launch(Dispatchers.IO){
            repository.deleteAllRecords()
        }
    }
}

class SampleViewModelFactory(
    private val application: Application
): ViewModelProvider.Factory{
    override fun <T: ViewModel?>create(modelClass: Class<T>): T{
        @Suppress("UNCHECKED_CAST")
        if(modelClass.isAssignableFrom(SampleViewModel::class.java)){
            return SampleViewModel(application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}