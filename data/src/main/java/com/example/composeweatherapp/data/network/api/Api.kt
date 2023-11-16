package com.example.composeweatherapp.data.network.api

import com.example.composeweatherapp.data.network.models.Tyda
import com.example.composeweatherapp.data.network.utils.WorkResult
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
        @GET("v1/current.json")
        suspend fun getData(
            @Query("key") key: String = "cc68cf0fae1144c9a35105113231511",
            @Query("q") city: String = "London"
        ): WorkResult<Tyda>
}