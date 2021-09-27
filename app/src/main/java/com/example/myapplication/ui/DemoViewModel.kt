package com.example.myapplication.ui

import androidx.lifecycle.*
import com.example.data.ResultWrapper
import com.example.domain.interactors.GetDemoTestUseCase
import com.example.domain.model.WeatherForCast

class DemoViewModel(private val getDemoTestUseCase: GetDemoTestUseCase) : ViewModel() {

    private val _getDemo = MediatorLiveData<ResultWrapper<WeatherForCast?>>()

    // input

    internal val getDemo = MutableLiveData<Unit>()

    // outPut
    val getDemoOutPut: LiveData<ResultWrapper<WeatherForCast?>>
        get() = _getDemo

    // Transformation
    private val getDemoOutResult: LiveData<ResultWrapper<WeatherForCast?>> =
        Transformations.switchMap(getDemo) {
            getDemoTestUseCase.execute()
        }


    init{
        _getDemo.addSource(getDemoOutResult){
            _getDemo.postValue(it)
        }
    }
}