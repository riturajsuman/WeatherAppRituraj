package com.example.myapplication.ui

import androidx.lifecycle.*
import com.example.data.ResultWrapper
import com.example.domain.interactors.GetDemoTestUseCase
import com.example.domain.model.DemoListItem

class DemoViewModel(private val getDemoTestUseCase: GetDemoTestUseCase) : ViewModel() {

    private val _getDemo = MediatorLiveData<ResultWrapper<List<DemoListItem>?>>()

    // input

    internal val getDemo = MutableLiveData<Unit>()

    // outPut
    val getDemoOutPut: LiveData<ResultWrapper<List<DemoListItem>?>>
        get() = _getDemo

    // Transformation
    private val getDemoOutResult: LiveData<ResultWrapper<List<DemoListItem>?>> =
        Transformations.switchMap(getDemo) {
            getDemoTestUseCase.execute()
        }


    init{
        _getDemo.addSource(getDemoOutResult){
            _getDemo.postValue(it)
        }
    }
}