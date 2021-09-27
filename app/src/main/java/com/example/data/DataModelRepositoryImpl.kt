package com.example.data

import com.example.data.mapper.toGetBBBDataList
import com.example.data.model.WeatherForCastResponse
import com.example.domain.repo.DataConfigRepository
import com.example.domain.model.WeatherForCast
import com.example.network.RepoAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class DataModelRepositoryImpl(private val repoAPI: RepoAPI) : DataConfigRepository {
    override suspend fun getDataConfig(): ResultWrapper<WeatherForCast?> {
        return suspendCoroutine { cont ->
            repoAPI.getCatRandom().enqueue(object : Callback<WeatherForCastResponse> {

                override fun onFailure(call: Call<WeatherForCastResponse>, t: Throwable) {
                    cont.resume(ResultWrapper.NetWorkError)
                }

                override fun onResponse(
                    call: Call<WeatherForCastResponse>,
                    response: Response<WeatherForCastResponse>
                ) {
                    val c =
                        ResultWrapper.Success(response.body()?.toGetBBBDataList())
                    cont.resume(c)
                }
            })
        }
    }
}