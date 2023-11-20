package com.example.composeweatherapp.presentation.ui.screens.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.composeweatherapp.presentation.utils.theme.CardBackground

@Composable
fun ListItems(model: List<WeatherModel>, vm: HomeViewModel, index: Int) {
    LazyColumn {
        itemsIndexed(
            model
        ) { _, item ->
            ListItem(item,vm,index)
        }
    }
}

@Composable
fun ListItem(model: WeatherModel, vm: HomeViewModel, index: Int) {
    val currentTemp = if (index != 1) {
        model.currentTemp + "°С"
    } else {
        "${model.maxTemp}°С / ${model.minTemp}°С"
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 3.dp)
            .clickable {
                if (index == 1) {
                    vm.itemClick(model)
                }
            },
        colors = CardDefaults.cardColors(CardBackground),
        shape = RoundedCornerShape(5.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(Modifier.fillMaxWidth(0.25f)) {
                Text(text = model.time)
                Text(
                    text = model.condition,
                    color = Color.White
                )
            }
            Text(
                text = currentTemp,
                color = Color.White
            )
            AsyncImage(
                model = "https:${model.icon}", contentDescription = "icon",
                modifier = Modifier.size(35.dp)
            )
        }

    }
}