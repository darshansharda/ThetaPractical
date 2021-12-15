package com.practicle.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.practicle.api.ApiHelper
import com.practicle.model.FamilyData
import com.practicle.utils.Resource
import kotlinx.coroutines.launch

class HomeViewModel(private val apiHelper: ApiHelper) : ViewModel() {

    private val response = MutableLiveData<Resource<List<FamilyData>>>()

    init {
        getData()
    }

    private fun getData() {
        viewModelScope.launch {
            response.postValue(Resource.loading(null))
            try {
                val familyData = apiHelper.getFamily("http://139.162.53.200:3000/")
                response.postValue(Resource.success(familyData.body()))
            } catch (e: Exception) {
                response.postValue(Resource.error(e.toString(), null))
            }
        }
    }

    fun getFamily(): LiveData<Resource<List<FamilyData>>> {
        return response
    }


}