package com.example.composeweatherapp.data.network.di

import android.app.Application
import android.content.Context
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.example.composeweatherapp.data.network.adapter.ResultAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun provideContext(application: Application): Context = application

    @Provides
    fun provideOkhttpClient(context: Context): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(ChuckerInterceptor.Builder(context).build())
        .build()

    @Provides
    fun provideRetrofit(client: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl("https://api.weatherapi.com/")
        .client(client)
        .addCallAdapterFactory(ResultAdapterFactory())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}