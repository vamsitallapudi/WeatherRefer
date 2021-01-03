package com.coderefer.weatherrefer.data.entity

import com.google.gson.annotations.SerializedName

data class Weather(
    @SerializedName("weather")
    val details: List<WeatherDetails>,
    @SerializedName("main")
    val temp: Temperature
)
