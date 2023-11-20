package com.example.composeweatherapp.data.network.models

import com.google.gson.annotations.SerializedName

data class LocationEntity(
    @SerializedName("name")
    val name: String = ""
)
