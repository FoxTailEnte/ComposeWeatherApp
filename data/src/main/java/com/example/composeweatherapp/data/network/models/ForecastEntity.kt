package com.example.composeweatherapp.data.network.models

import com.google.gson.annotations.SerializedName

data class ForecastEntity(
    @SerializedName("forecastday")
    val forecastday: List<DayEntity>
)