package com.example.composeweatherapp.data

import com.example.composeweatherapp.data.maper.ResponseUtils
import com.example.composeweatherapp.data.network.api.Api
import com.example.composeweatherapp.domain.HomeAsFlow
import javax.inject.Inject

class HomeAsFlowImpl @Inject constructor(
    private val api: Api
): HomeAsFlow {

    override suspend fun getHomeData() = ResponseUtils.handleResult(api.getData())
}