package com.example.network


import com.example.data.model.WeatherForCastResponse
import retrofit2.Call
import retrofit2.http.GET

interface RepoAPI {
    @GET("?q=singapore&mode=JSON&appid=00c9b6c30412cff5faeb59efec4d6afc")
    fun getCatRandom() : Call<WeatherForCastResponse>
}