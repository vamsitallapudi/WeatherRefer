package com.coderefer.weatherrefer.data.api

import com.coderefer.weatherrefer.data.entity.Weather
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {

    @GET("weather")
    fun getWeatherAsync(
        @Query("q") city: String,
        @Query("appid") appId: String,
        @Query("units") units: String
    ) : Deferred<Response<Weather>>

    companion object {
        const val BASE_URL = "http://api.openweathermap.org/data/2.5/"
    }
}