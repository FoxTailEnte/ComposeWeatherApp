package com.example.composeweatherapp.presentation.ui.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.TabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.composeweatherapp.presentation.utils.theme.CardBackground
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun HomeTab(vm: HomeViewModel) {
    val days by vm.dayModel.collectAsState()
    val hours by vm.hoursModel.collectAsState()
    val tabList = listOf("HOURS", "DAYS")
    val pagerState = rememberPagerState()
    val tabIndex = pagerState.currentPage
    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .padding(horizontal = 5.dp)
            .clip(RoundedCornerShape(5.dp))

    ) {
        TabRow(
            selectedTabIndex = tabIndex,
            indicator = { pos ->
                TabRowDefaults.Indicator(
                    modifier = Modifier.pagerTabIndicatorOffset(pagerState, pos)
                )
            },
            backgroundColor = CardBackground
        ) {
            tabList.forEachIndexed { index, text ->
                Tab(
                    selected = false, onClick = {
                        scope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    },
                    text = {
                        Text(text = text)
                    })
            }
        }
        HorizontalPager(count = tabList.size,
            state = pagerState
        ) { index ->
            ListItems(if(index == 1)days ?: listOf() else hours ?: listOf(), vm, index)

        }
    }
}