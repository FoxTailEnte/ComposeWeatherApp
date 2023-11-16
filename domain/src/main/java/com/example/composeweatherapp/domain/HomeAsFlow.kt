package com.example.composeweatherapp.domain

import com.example.composeweatherapp.domain.utils.HandleResponse

interface HomeAsFlow {

    suspend fun getHomeData(): HandleResponse
}