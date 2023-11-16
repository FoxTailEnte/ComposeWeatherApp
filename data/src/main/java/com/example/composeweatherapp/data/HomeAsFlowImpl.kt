package com.example.composeweatherapp.data

import com.example.composeweatherapp.data.network.api.Api
import com.example.composeweatherapp.data.network.models.Tyda
import com.example.composeweatherapp.data.network.utils.WorkResult
import javax.inject.Inject

class HomeAsFlowImpl @Inject constructor(
    private val api: Api
): HomeAsFlow {

    override suspend fun getHomeData(): WorkResult<Tyda> = api.getData()

}