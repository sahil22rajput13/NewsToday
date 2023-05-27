package com.example.newstoday

import com.example.newstoday.api.NewsJson
import retrofit2.Call
import retrofit2.http.GET

interface APIRequest  {
    @GET ("/v1/latest-news?language=en&apiKey=7goxs3CKQUAJRGhquf6BovIkIToi_vj5Uii2lTrQCVE9EtY2")
    fun getNews():Call<NewsJson>

}