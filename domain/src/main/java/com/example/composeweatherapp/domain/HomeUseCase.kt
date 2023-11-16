package com.example.composeweatherapp.domain

import com.example.composeweatherapp.data.HomeAsFlow
import com.example.composeweatherapp.data.network.models.Tyda
import com.example.composeweatherapp.data.network.utils.WorkResult
import javax.inject.Inject


class HomeUseCase @Inject constructor(
    private val homeAsFlow: com.example.composeweatherapp.data.HomeAsFlow
){
    suspend operator fun invoke(): com.example.composeweatherapp.data.network.utils.WorkResult<com.example.composeweatherapp.data.network.models.Tyda> = homeAsFlow.getHomeData()

}