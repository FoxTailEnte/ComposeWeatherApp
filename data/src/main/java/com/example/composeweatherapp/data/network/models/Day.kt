package com.example.composeweatherapp.data.network.models

import com.google.gson.annotations.SerializedName

data class Day(
    @SerializedName("mintemp_c")
    val mintemp_c: Float = 0.0f,
    @SerializedName("maxtemp_c")
    val maxtemp_c: Float = 0.0f,
    @SerializedName("condition")
    val condition: ConditionDay
)
