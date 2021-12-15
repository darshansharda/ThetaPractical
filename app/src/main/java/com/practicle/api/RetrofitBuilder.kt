package com.practicle.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {

    private const val BASE_URL = "http://139.162.53.200:3000/"

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

//  2012-07-10.json?app_id=b8170f2960a546378a5ceb06a7bb6f59

    val apiService: ApiService = getRetrofit().create(ApiService::class.java)

}