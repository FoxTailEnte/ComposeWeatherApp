package com.example.composeweatherapp.presentation.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composeweatherapp.data.network.models.WeatherEntity
import com.example.composeweatherapp.data.network.utils.WorkResult
import com.example.composeweatherapp.domain.HomeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homeUseCase: HomeUseCase
) : ViewModel() {
    val dayModel = MutableStateFlow<List<WeatherModel>?>(null)
    val hoursModel = MutableStateFlow<List<WeatherModel>?>(null)
    val cardModel = MutableStateFlow<WeatherModel?>(null)
    val cardState = MutableStateFlow(State.BASE)
    val searchState = MutableStateFlow(false)
    private val error = MutableStateFlow<String?>(null)

    fun getData(city: String = "Rostov-On-Don") {
        viewModelScope.launch(Dispatchers.IO) {
            setState(homeUseCase(city))
        }
    }

    fun itemClick(model: WeatherModel) {
        viewModelScope.launch(Dispatchers.IO) {
            cardState.emit(State.CLICK)
            parseToHours(model)
            parseToCard(model)
        }
    }

    fun searchClick(state: Boolean) {
        viewModelScope.launch(Dispatchers.IO) {
            searchState.emit(state)
        }
    }

    private suspend fun setState(response: WorkResult<WeatherEntity>) {
        when (response) {
            is WorkResult.SuccessResult -> {
                val days = parseToDays(response.data)
                parseToHours(days[0])
                parseToCard(days[0])
            }

            is WorkResult.EmptyResult -> Unit
            is WorkResult.ErrorResult -> error.emit(response.message)
            is WorkResult.Fail -> Unit
        }
    }

    private suspend fun parseToDays(response: WeatherEntity): List<WeatherModel> {
        val list = mutableListOf<WeatherModel>()
        response.forecast.forecastday.forEach {
            list.add(
                WeatherModel(
                    response.location.name,
                    it.date,
                    response.current.lastUpdate,
                    response.current.temp.toString(),
                    response.current.condition.weather,
                    it.day.condition.icon,
                    it.day.maxtemp_c.toString(),
                    it.day.mintemp_c.toString(),
                    it.hour
                )
            )
        }
        dayModel.emit(list)
        return list
    }

    private suspend fun parseToHours(response: WeatherModel) {
        val list = mutableListOf<WeatherModel>()
        response.hours?.forEach {
            list.add(
                WeatherModel(
                    response.city,
                    it.time.takeLast(5),
                    response.currentTemp ?: "",
                    it.temp.toString(),
                    it.condition.weather,
                    it.condition.icon,
                    null,
                    null,
                    response.hours
                )
            )
        }
        hoursModel.emit(list)
    }

    private suspend fun parseToCard(response: WeatherModel) {
        cardModel.emit(response)
    }

    enum class State {
        CLICK,
        BASE
    }
}