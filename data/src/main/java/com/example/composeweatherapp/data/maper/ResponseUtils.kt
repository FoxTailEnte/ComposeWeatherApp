package com.example.composeweatherapp.data.maper

import com.example.composeweatherapp.data.network.models.LocationEntity
import com.example.composeweatherapp.data.network.models.WeatherEntity
import com.example.composeweatherapp.data.network.utils.WorkResult
import com.example.composeweatherapp.domain.model.LocationData
import com.example.composeweatherapp.domain.model.WeatherData
import com.example.composeweatherapp.domain.utils.HandleResponse

object ResponseUtils {

    fun handleResult(data: WorkResult<WeatherEntity>): HandleResponse {
        return when (data) {
            is WorkResult.SuccessResult -> HandleResponse.Succes(map(data.data))
            is WorkResult.EmptyResult -> HandleResponse.Empty
            is WorkResult.ErrorResult -> HandleResponse.Error(data.exception, data.message)
            is WorkResult.Fail -> HandleResponse.Fail
        }
    }

    private fun map(model: WeatherEntity): WeatherData {
        return WeatherData(
            location = mapLocationData(model.location)
        )
    }

    private fun mapLocationData(data: LocationEntity): LocationData {
        return LocationData(
            data.name
        )
    }
}