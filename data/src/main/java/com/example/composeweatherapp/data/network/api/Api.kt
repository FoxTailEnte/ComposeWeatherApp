package com.example.composeweatherapp.data.network.api

import com.example.composeweatherapp.data.network.models.WeatherEntity
import com.example.composeweatherapp.data.network.utils.WorkResult
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
        @GET("v1/forecast.json?")
        suspend fun getData(
            @Query("key") key: String = "cc68cf0fae1144c9a35105113231511",
            @Query("q") city: String? = "Rostov-On-Don",
            @Query("aqi") aqi: String = "no",
            @Query("alerts") alerts: String = "no",
            @Query("days") days: String = "30"
        ): WorkResult<WeatherEntity>
}