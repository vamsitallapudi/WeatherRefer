package com.coderefer.weatherrefer.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.coderefer.weatherrefer.data.CoroutineDispatchProvider
import com.coderefer.weatherrefer.data.Result
import com.coderefer.weatherrefer.data.WeatherRepo
import com.coderefer.weatherrefer.data.entity.Weather
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

// TODO: use DI to inject repo
class HomeViewModel(private val repo: WeatherRepo) : ViewModel() {

    private val weatherMutableLiveData = MutableLiveData<Result<Weather>>()
    val weatherLiveData: LiveData<Result<Weather>>
        get() = weatherMutableLiveData

    val dispatchProvider by lazy {
        CoroutineDispatchProvider()
    }

    fun fetchWeather(): Job {
        return viewModelScope.launch(dispatchProvider.io) {
            withContext(dispatchProvider.main) {
                showLoading()
            }
            val result = repo.fetchWeather()
            result.collect {
                when (it) {
                    is Result.Success<*> -> {
                        weatherMutableLiveData.postValue(it as Result<Weather>)
                    }
                    is Result.Error -> {
                        weatherMutableLiveData.postValue(it)
                    }
                    is Result.Loading -> {
                        //TODO
                    }
                }
            }
        }
    }

    private fun showLoading() {
//        TODO("Not yet implemented")
    }
}