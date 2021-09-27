package com.example.domain.repo

import com.example.data.ResultWrapper
import com.example.domain.model.WeatherForCast

interface DataConfigRepository {
    suspend fun getDataConfig() : ResultWrapper<WeatherForCast?>
}