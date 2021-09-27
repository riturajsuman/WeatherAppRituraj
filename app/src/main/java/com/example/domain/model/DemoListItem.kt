package com.example.domain.model


data class WeatherForCast(

    val city: CityModel,

    val cnt: Int,

    val cod: String,

    val message: Int,

    val list: List<WeatherList>
)



data class CityModel(
    val country: String,
    val name: String,
    val population: Int,
    val sunrise: Int,
    val sunset: Int,
    val timezone: Int
)


data class WeatherList(
    val main: Main,
    val dt_txt: String,
    val weather: List<Weather>
)

data class Main(
    val humidity: Int,

    val temp: Double,

    val temp_max: Double,

    val temp_min: Double
)


data class Weather(
    val description: String,
    val main: String
)