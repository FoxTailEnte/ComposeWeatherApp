package com.example.composeweatherapp.data.network.models

import com.google.gson.annotations.SerializedName

data class ConditionEntity(
    @SerializedName("icon")
    val icon: String?,
    @SerializedName("text")
    val weather: String = ""
)