package com.synerzip.assigment.api

import com.synerzip.assigment.models.ResponseModell
import retrofit2.http.GET

interface ApiService {
    //https://itunes.apple.com/us/rss/newfreeapplications/limit=2/json
   // "/s/2iodh4vg0eortkl/facts.json/"
    @GET("/us/rss/newfreeapplications/limit=2/json")
    suspend fun getNewsResponse(): ResponseModell
}