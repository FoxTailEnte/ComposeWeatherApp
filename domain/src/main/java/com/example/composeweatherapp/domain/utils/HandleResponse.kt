package com.example.composeweatherapp.domain.utils

import com.example.composeweatherapp.domain.model.WeatherData
import java.lang.Exception

sealed class HandleResponse {
    class Succes(val data: WeatherData): HandleResponse()
    object Empty: HandleResponse()
    class Error(val exception: Exception, val message: String?): HandleResponse()
    object Fail: HandleResponse()
}