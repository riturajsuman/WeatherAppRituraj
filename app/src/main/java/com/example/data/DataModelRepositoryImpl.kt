package com.example.data

import android.util.Log
import com.example.data.mapper.toGetBBBdataList
import com.example.data.model.DemoModelItem
import com.example.data.model.RealDemoResponse
import com.example.domain.repo.DataConfigRepository
import com.example.domain.model.DemoListItem
import com.example.network.RepoAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class DataModelRepositoryImpl(private val repoAPI: RepoAPI) : DataConfigRepository {
    override suspend fun getDataConfig(): ResultWrapper<List<DemoListItem>?> {
        return suspendCoroutine { cont ->
            repoAPI.getCatRandom().enqueue(object : Callback<List<DemoModelItem>> {

                override fun onFailure(call: Call<List<DemoModelItem>>, t: Throwable) {
                    cont.resume(ResultWrapper.NetWorkError)
                }

                override fun onResponse(
                    call: Call<List<DemoModelItem>>,
                    response: Response<List<DemoModelItem>>
                ) {
                    val c =
                        ResultWrapper.Success(response.body()?.toGetBBBdataList())
                    cont.resume(c)
                }
            })
        }
    }
}