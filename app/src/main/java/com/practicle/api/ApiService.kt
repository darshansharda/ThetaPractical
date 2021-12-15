package com.practicle.api

import com.practicle.model.FamilyData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiService {

    @GET()
    suspend fun getFamily(@Url url: String): Response<List<FamilyData>>

}