package com.example.composeweatherapp.domain.di


import com.example.composeweatherapp.data.HomeAsFlowImpl
import com.example.composeweatherapp.domain.HomeUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class HomeDomainModule {

    @Provides
    fun provideHomeUseCase(asFlow: HomeAsFlowImpl): HomeUseCase = HomeUseCase(asFlow)
}