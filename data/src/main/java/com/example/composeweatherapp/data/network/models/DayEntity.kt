package com.example.composeweatherapp.data.network.models

import com.google.gson.annotations.SerializedName

data class DayEntity(
    @SerializedName("date")
    val date: String = "",
    @SerializedName("day")
    val day: Day,
    @SerializedName("hour")
    val hour: List<HoursEntity>
)