package com.practicle.api

class ApiHelperImpl(private val apiService: ApiService) : ApiHelper {

    override suspend fun getFamily(url:String) = apiService.getFamily(url)

}