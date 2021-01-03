package com.coderefer.weatherrefer.data

import kotlinx.coroutines.flow.Flow

class WeatherRepo(
    private val localDataSource: WeatherLocalDataSource,
    private val remoteDataSource: WeatherRemoteDataSource
) {
    suspend fun fetchWeather(): Flow<Result<*>> {
        return remoteDataSource.fetchWeather()
    }
}