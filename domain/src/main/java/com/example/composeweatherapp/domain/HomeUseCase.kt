package com.example.composeweatherapp.domain

import com.example.composeweatherapp.domain.utils.HandleResponse
import javax.inject.Inject


class HomeUseCase @Inject constructor(
    private val homeAsFlow: HomeAsFlow
){

    suspend operator fun invoke(): HandleResponse = homeAsFlow.getHomeData()

}