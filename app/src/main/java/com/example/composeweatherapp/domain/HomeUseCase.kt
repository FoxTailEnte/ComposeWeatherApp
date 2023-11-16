package com.example.composeweatherapp.domain

import com.example.composeweatherapp.data.HomeAsFlow
import com.example.composeweatherapp.data.network.models.Tyda
import com.example.composeweatherapp.data.network.utils.WorkResult
import retrofit2.Response
import javax.inject.Inject


class HomeUseCase @Inject constructor(
    private val homeAsFlow: HomeAsFlow
){
    suspend operator fun invoke(): WorkResult<Tyda> = homeAsFlow.getHomeData()

}