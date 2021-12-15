package com.practicle.api

import com.practicle.model.FamilyData
import retrofit2.Response

interface ApiHelper {

    suspend fun getFamily(url: String): Response<List<FamilyData>>

}