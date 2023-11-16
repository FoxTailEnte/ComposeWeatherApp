package com.example.composeweatherapp.data.network.di

import com.example.composeweatherapp.data.network.api.Api
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
class ApiModule {

   @Provides
   fun provideApi(retrofit: Retrofit): Api = retrofit.create(Api::class.java)
}