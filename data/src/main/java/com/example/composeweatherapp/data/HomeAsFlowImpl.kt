package com.example.composeweatherapp.data

import com.example.composeweatherapp.data.network.api.Api
import javax.inject.Inject

class HomeAsFlowImpl @Inject constructor(
    private val api: Api
): HomeAsFlow {

    override suspend fun getHomeData(city: String?) = api.getData(city = city)
}