package com.example.composeweatherapp.data.network.models

import com.google.gson.annotations.SerializedName

data class Tyda(
    @SerializedName("location")
    val location: Location
)

data class Location(
    @SerializedName("name")
    val name: String = "nothing"
)
