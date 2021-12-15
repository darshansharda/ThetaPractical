package com.practicle.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.practicle.api.ApiHelper
import com.practicle.viewmodel.HomeViewModel

class ViewModelFactory(private val apiHelper: ApiHelper) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(apiHelper) as T
        }

        throw IllegalArgumentException("Unknown class name")
    }

}