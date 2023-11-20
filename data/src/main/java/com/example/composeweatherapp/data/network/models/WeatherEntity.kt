package com.example.composeweatherapp.data.network.models

import com.google.gson.annotations.SerializedName

data class WeatherEntity(
    @SerializedName("location")
    val location: LocationEntity,
    @SerializedName("current")
    val current: CurrentEntity,
    @SerializedName("forecast")
    val forecast: ForecastEntity
)
