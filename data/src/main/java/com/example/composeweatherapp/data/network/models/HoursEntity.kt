package com.example.composeweatherapp.data.network.models

import com.google.gson.annotations.SerializedName

data class HoursEntity(
    @SerializedName("time")
    val time: String = "",
    @SerializedName("temp_c")
    val temp: Float = 0.0f,
    @SerializedName("condition")
    val condition: ConditionDay,
)
