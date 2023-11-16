package com.example.composeweatherapp.data.network.utils

import java.io.IOException

class NetworkException(e: IOException) : IOException(e)

class UndefinedException(e: Throwable) : Exception(e)

class NetworkHttpException(val code: Int, message: String) : Exception()