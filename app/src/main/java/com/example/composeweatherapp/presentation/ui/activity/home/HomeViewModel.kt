package com.example.composeweatherapp.presentation.ui.activity.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composeweatherapp.domain.HomeUseCase
import com.example.composeweatherapp.domain.utils.HandleResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homeUseCase: HomeUseCase
) : ViewModel() {
    val state = MutableStateFlow<String?>("Nothing")

    fun getData() {
        viewModelScope.launch(Dispatchers.IO) {
                setState(homeUseCase())
        }
    }

    private suspend fun setState(response: HandleResponse) {
        when (response) {
            is HandleResponse.Succes -> state.emit(response.data.location.name)
            is HandleResponse.Empty -> state.emit("")
            is HandleResponse.Error -> state.emit(response.message)
            is HandleResponse.Fail -> Unit
        }
    }
}