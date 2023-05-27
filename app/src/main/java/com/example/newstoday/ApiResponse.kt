package com.example.newstoday

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiResponse {
    val api by lazy {
        Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(APIRequest::class.java)
    }
}