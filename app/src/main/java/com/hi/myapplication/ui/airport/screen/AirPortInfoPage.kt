//飛機頁面

package com.hi.myapplication.ui.airport.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement.Absolute.Center
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.hi.myapplication.R
import com.hi.myapplication.ui.airport.AirportInfoViewModel
import kotlinx.coroutines.launch

@Preview
@Composable
fun AirportInfoPage() {
    val pagerState = rememberPagerState(pageCount = { 2 })
    val scope = rememberCoroutineScope()
    var indexindex by remember { mutableStateOf(0) }

    Column {
        Box(modifier = Modifier.padding( 0.dp)) {
            //上面的選取框
            TabRow(selectedTabIndex = pagerState.currentPage) {
                val tabs = listOf("起飛班機", "抵達班機")
                tabs.forEachIndexed { index, title ->
                    Surface(onClick = {
                        scope.launch {
                            indexindex = index
                            pagerState.animateScrollToPage(index)
                        }
                    }) {
                        Row(
                            verticalAlignment = CenterVertically,
                            horizontalArrangement = Center
                        ) {
                            Image(
                                modifier = Modifier
                                    .size(30.dp)
                                    .align(Alignment.CenterVertically)
                                    .clip(RectangleShape),
                                painter = allIcon(page = index),
                                contentDescription = null
                            )
                            Text(
                                text = title,
                                //點擊交換顏色
                                color = if (indexindex == index) {
                                    MaterialTheme.colorScheme.primary
                                } else  MaterialTheme.colorScheme.secondary
                            )

                        }
                    }
                }
            }
        }
        //中間的頁面
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .padding(0.dp)
                .fillMaxSize()
        ) { page ->
            val viewModel: AirportInfoViewModel = hiltViewModel()
            //分辨起飛 抵達
            when (page) {
                0 -> {
                    DepartingFlightPage(viewModel)
                }

                1 -> {
                    ArrivalFlightPage(viewModel)
                }
            }
        }
    }
}


@Composable
//圖案
fun allIcon(page: Int): Painter {
    return when (page) {
        //抵達
        0 -> painterResource(id = R.mipmap.landing)
        //起飛
        1 -> painterResource(id = R.mipmap.take_off)
        else -> {
            //預設
            painterResource(id = R.mipmap.take_off)
        }
    }
}

@Composable
fun ArrivalFlightPage(model: AirportInfoViewModel) {
    //抵達
    BaseFlightPage(viewModel = model,"D")
}

@Composable
fun DepartingFlightPage(model: AirportInfoViewModel) {
    //起飛
    BaseFlightPage(viewModel = model,"U")
}

@Preview
@Composable
private fun Test() {
    AirportInfoPage()
}
