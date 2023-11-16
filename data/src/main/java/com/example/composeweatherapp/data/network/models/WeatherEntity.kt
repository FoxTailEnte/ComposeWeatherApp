package com.example.composeweatherapp.data.network.models

import com.google.gson.annotations.SerializedName

data class WeatherEntity(
    @SerializedName("location")
    val location: LocationEntity
)

data class LocationEntity(
    @SerializedName("name")
    val name: String = "nothing"
)
