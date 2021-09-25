package com.example.data.model

import com.google.gson.annotations.SerializedName

data class RealDemoResponse(
    val demoModelData: List<DemoModelItem>
)

data class Location(
    @SerializedName("coordinates")
    val coordinates: List<Double>,
    @SerializedName("type")
    val type: String
)

data class DemoModelItem(
    @SerializedName("depth")
    val depth: String,
    @SerializedName("earthquake_id")
    val earthquake_id: String,
    @SerializedName("location")
    val location: Location,
    @SerializedName("magnitude")
    val magnitude: String,
    @SerializedName("number_of_stations")
    val number_of_stations: String,
    @SerializedName("region")
    val region: String,
    @SerializedName("source")
    val source: String,
    @SerializedName("version")
    val version: String
)