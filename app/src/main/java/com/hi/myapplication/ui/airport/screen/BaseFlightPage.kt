//這邊是用來更新的 現在只是傳遞資料

package com.hi.myapplication.ui.airport.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.hi.myapplication.ui.airport.AirportInfoViewModel
import com.hi.myapplication.ui.airport.components.AirportInfoItem
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BaseFlightPage(viewModel: AirportInfoViewModel, string: String) {

    val data = viewModel.flightList.collectAsState()

    val refreshState = remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()
    val UD = string

    LaunchedEffect(viewModel) {
        viewModel.fetchFlightList()
    }

    PullToRefreshBox(
        isRefreshing = refreshState.value,
        onRefresh = {
            scope.launch {
                refreshState.value = true
                viewModel.fetchFlightList()
                delay(1500)
                refreshState.value = false
            }
        }
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
        ) {
            if (!refreshState.value) {
                if (data.value.isNotEmpty()) {
                    items(data.value) {
                        AirportInfoItem(it, UD)
                    }
                    item {
                        Spacer(modifier = Modifier.padding(45.dp))
                    }
                }
            }
        }

    }
}