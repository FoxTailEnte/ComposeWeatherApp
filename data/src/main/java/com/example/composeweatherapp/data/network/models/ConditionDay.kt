package com.example.composeweatherapp.data.network.models

import com.google.gson.annotations.SerializedName

data class ConditionDay(
    @SerializedName("text")
    val weather: String = "",
    @SerializedName("icon")
    val icon: String = "",
)
