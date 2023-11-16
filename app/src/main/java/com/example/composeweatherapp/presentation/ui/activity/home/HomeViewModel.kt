package com.example.composeweatherapp.presentation.ui.activity.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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
    val state = MutableStateFlow<String?>("Nothing")

    fun getData() {
        viewModelScope.launch(Dispatchers.IO) {
            val i = homeUseCase()
            if(i is WorkResult.SuccessResult)
                i.data.location.name
        }
    }
}