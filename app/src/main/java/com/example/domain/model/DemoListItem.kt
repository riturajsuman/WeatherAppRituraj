package com.example.domain.model

import com.example.data.model.Location

data class DemoListItem(
    val depth: String? = null,
    val earthquake_id: String? = null,
    val location: Location? = null,
    val magnitude: String? = null,
    val number_of_stations: String? = null,
    val region: String? = null,
    val source: String? = null,
    val version: String? = null
)