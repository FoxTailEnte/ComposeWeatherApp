package com.example.composeweatherapp.data.network.utils

import com.google.gson.annotations.SerializedName

class ErrorDto(
    @SerializedName("success")
    val success: Boolean?,

    @SerializedName("message")
    val message: String?,

    @SerializedName("errors")
    val errors: List<String>?
)