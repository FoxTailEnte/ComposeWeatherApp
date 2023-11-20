package com.example.composeweatherapp.data.network.di

import com.example.composeweatherapp.data.HomeAsFlow
import com.example.composeweatherapp.data.HomeAsFlowImpl
import com.example.composeweatherapp.data.network.api.Api
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class BaseModel {

    @Provides
    fun provideHomeInfoAsFlow(api: Api): HomeAsFlow = HomeAsFlowImpl(api)
}