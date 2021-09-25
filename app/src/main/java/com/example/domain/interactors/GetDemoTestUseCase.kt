package com.example.domain.interactors

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.cleanarch.UseCase
import com.example.data.ResultWrapper
import com.example.domain.model.DemoListItem
import com.example.domain.repo.DataConfigRepository
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class GetDemoTestUseCase(private val dataConfig: DataConfigRepository) : UseCaseScope,
    UseCase<LiveData<ResultWrapper<List<DemoListItem>?>>> {

    override fun execute(): LiveData<ResultWrapper<List<DemoListItem>?>> {
        val result = MutableLiveData<ResultWrapper<List<DemoListItem>?>>()
        launch {
            val toPost = when (val response = dataConfig.getDataConfig()) {
                is ResultWrapper.Success -> ResultWrapper.Success(response.value)
                is ResultWrapper.GenericError -> ResultWrapper.GenericError(
                    message = response.message,
                    exception = response.exception
                )
                else -> ResultWrapper.NetWorkError

            }
            result.postValue(toPost)
        }
        return result
    }

    override fun cancel() {
        coroutineContext.cancel()
    }

}