package com.example.domain.repo

import com.example.data.ResultWrapper
import com.example.domain.model.DemoListItem

interface DataConfigRepository {
    suspend fun getDataConfig() : ResultWrapper<List<DemoListItem>?>
}