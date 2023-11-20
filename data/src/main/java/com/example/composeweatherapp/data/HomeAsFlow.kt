package com.example.composeweatherapp.data

import com.example.composeweatherapp.data.network.models.WeatherEntity
import com.example.composeweatherapp.data.network.utils.WorkResult

interface HomeAsFlow {

    suspend fun getHomeData(city: String?): WorkResult<WeatherEntity>
}