package com.coderefer.weatherrefer.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.coderefer.weatherrefer.data.WeatherRepo
import java.lang.IllegalArgumentException

class ViewModelFactory(val weatherRepo: WeatherRepo) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(weatherRepo) as T
        }
        throw IllegalArgumentException("Unknown viewmodel class")
    }
}