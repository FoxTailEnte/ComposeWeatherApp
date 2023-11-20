package com.example.composeweatherapp.presentation.ui.screens.home

import com.example.composeweatherapp.data.network.models.HoursEntity

data class WeatherModel(
    val city: String,
    val time: String,
    val lastUpdate: String,
    val currentTemp: String?,
    val condition: String,
    val icon: String,
    val maxTemp: String?,
    val minTemp: String?,
    val hours: List<HoursEntity>?,
)
