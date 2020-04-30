package com.synerzip.assigment.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {
    //https://itunes.apple.com/us/rss/newfreeapplications/limit=2/json
    //"https://dl.dropboxusercontent.com"
    const val BASE_URL = "https://itunes.apple.com"

    val retrofitBuilder: Retrofit.Builder by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
    }

    val apiService: ApiService by lazy {
        retrofitBuilder
            .build()
            .create(ApiService::class.java)
    }
}