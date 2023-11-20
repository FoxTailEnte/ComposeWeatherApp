package com.example.composeweatherapp.data.network.models

import com.google.gson.annotations.SerializedName

data class CurrentEntity(
    @SerializedName("condition")
    val condition: ConditionEntity,
    @SerializedName("temp_c")
    val temp: Float = 0.0f,
    @SerializedName("last_updated")
    val lastUpdate: String = "",
)
