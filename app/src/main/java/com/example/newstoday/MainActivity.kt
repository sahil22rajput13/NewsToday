package com.example.newstoday

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newstoday.api.NewsJson
import com.example.newstoday.databinding.ActivityMainBinding
import com.federicocotogno.retro2newslist.adapters.RecyclerAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


const val BASE_URL = "https://api.currentsapi.services"
lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var titlesList = mutableListOf<String>()
    private var descList = mutableListOf<String>()
    private var imagesList = mutableListOf<String>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fetchdata()


    }

    private fun fetchdata() {
         ApiResponse.api.getNews().enqueue(object : Callback<NewsJson?> {
             override fun onResponse(call: Call<NewsJson?>, response: Response<NewsJson?>) {
                 val list = response.body()!!.news


                 binding.rvRecyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
                 val adapter = RecyclerAdapter(list,this@MainActivity)
                 binding.rvRecyclerView.adapter = adapter

             }

             override fun onFailure(call: Call<NewsJson?>, t: Throwable) {
                 TODO("Not yet implemented")
             }
         })

    }




}
