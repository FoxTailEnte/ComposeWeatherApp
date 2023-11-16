package com.example.composeweatherapp.data

import com.example.composeweatherapp.data.network.models.Tyda
import com.example.composeweatherapp.data.network.utils.WorkResult
import retrofit2.Response

interface HomeAsFlow {

    suspend fun getHomeData(): WorkResult<Tyda>
}