package com.example.data.mapper

import com.example.data.model.WeatherForCastResponse
import com.example.domain.model.*

fun WeatherForCastResponse.toGetBBBDataList(): WeatherForCast {

    val watchList = this.list
    val mutableList = mutableListOf<WeatherList>()
    val weatherListDetail = mutableListOf<Weather>()
    watchList.forEach {
        val mainWatchList = it.main
        val main = Main(
            mainWatchList.humidity,
            mainWatchList.temp,
            mainWatchList.temp_max,
            mainWatchList.temp_min
        )
        val date = it.dt_txt
        val weatherList = it.weather


        weatherList.forEach { it1 ->
            weatherListDetail.add(Weather(it1.description, it1.main))
        }


        mutableList.add(WeatherList(main = main, dt_txt = date, weatherListDetail))
    }

    val city = CityModel(
        this.city.country,
        this.city.name,
        this.city.population,
        this.city.sunrise,
        this.city.sunset,
        this.city.timezone
    )

    return WeatherForCast(city, this.cnt, this.cod, this.message, mutableList)

}