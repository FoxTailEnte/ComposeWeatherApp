package com.example.composeweatherapp.domain

import com.example.composeweatherapp.data.HomeAsFlow
import com.example.composeweatherapp.data.network.models.WeatherEntity
import com.example.composeweatherapp.data.network.utils.WorkResult
import javax.inject.Inject


class HomeUseCase @Inject constructor(
    private val homeAsFlow: HomeAsFlow
){

    suspend operator fun invoke(city: String?): WorkResult<WeatherEntity> = homeAsFlow.getHomeData(city)

}