package com.example.composeweatherapp.domain.model

data class WeatherData(
    val location: LocationData
)
data class LocationData(
    val name: String = "nothing"
)
