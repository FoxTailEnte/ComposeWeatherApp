package com.example.composeweatherapp.presentation.ui.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.composeweatherapp.R
import com.example.composeweatherapp.presentation.utils.theme.CardBackground

@Composable
fun HomeCard(vm: HomeViewModel) {
    val cardModel by vm.cardModel.collectAsState()
    val state by vm.cardState.collectAsState()
    val searchState by vm.searchState.collectAsState()
    if(searchState) {
        DialogSearch(vm)
    }
    val icon = cardModel?.icon
    val city = cardModel?.city ?: ""
    val temp = when(state) {
        HomeViewModel.State.BASE -> cardModel?.currentTemp ?: 0.0f.toString()
        HomeViewModel.State.CLICK -> "${cardModel?.maxTemp}/${cardModel?.minTemp}"

    }
    val update = cardModel?.lastUpdate ?: ""
    val weather = cardModel?.condition
    val minTemp = cardModel?.minTemp ?: ""
    val maxTemp = cardModel?.maxTemp ?: ""
    Column {
        Card(
            modifier = Modifier
                .padding(5.dp),
            colors = CardDefaults.cardColors(CardBackground),
            shape = RoundedCornerShape(5.dp)
        ) {
            Column(
                Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        modifier = Modifier.padding(start = 8.dp, top = 8.dp),
                        text = "Last update - $update",
                        style = TextStyle(fontSize = 15.sp),
                        color = Color.White
                    )
                    AsyncImage(
                        model = "https:$icon", contentDescription = "icon",
                        modifier = Modifier.size(35.dp)
                    )

                }
                Text(
                    modifier = Modifier.padding(start = 8.dp, top = 8.dp),
                    text = city,
                    style = TextStyle(fontSize = 24.sp),
                    color = Color.White
                )
                Text(
                    modifier = Modifier.padding(start = 8.dp, top = 8.dp),
                    text = "$temp°С",
                    style = TextStyle(fontSize =  44.sp),
                    color = Color.White
                )
                Text(
                    modifier = Modifier.padding(start = 8.dp, top = 8.dp),
                    text = weather ?: "",
                    style = TextStyle(fontSize = 15.sp),
                    color = Color.White
                )
                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    IconButton(onClick = {
                        vm.searchClick(true)
                    }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_search),
                            contentDescription = "search",
                            tint = Color.White
                        )
                    }
                    Text(
                        modifier = Modifier.padding(start = 8.dp, top = 8.dp),
                        text = "Max: $maxTemp°С - Min: $minTemp°С",
                        style = TextStyle(fontSize = 12.sp),
                        color = Color.White
                    )
                    IconButton(onClick = {
                        vm.getData("Rostov-on-Don")
                    }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_sync),
                            contentDescription = "search",
                            tint = Color.White
                        )
                    }
                }
            }

        }

    }
}