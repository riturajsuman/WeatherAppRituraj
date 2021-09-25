package com.example.network

import com.example.data.model.DemoModelItem
import com.example.data.model.RealDemoResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface RepoAPI {
    @GET("?source=pr&region=Virgin%20Islands%20region")
    fun getCatRandom() : Call<List<DemoModelItem>>
}