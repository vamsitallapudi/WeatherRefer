package com.coderefer.weatherrefer

import android.app.Application
import com.coderefer.weatherrefer.data.WeatherLocalDataSource
import com.coderefer.weatherrefer.data.WeatherRemoteDataSource
import com.coderefer.weatherrefer.data.WeatherRepo

class WeatherReferApp : Application() {
    private val localDataSource by lazy {WeatherLocalDataSource()}
    private val remoteDataSource by lazy {WeatherRemoteDataSource(applicationContext)}
    val weatherRepo by lazy {
        WeatherRepo(localDataSource,remoteDataSource)
    }
}