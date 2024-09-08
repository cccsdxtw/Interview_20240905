//主要頁面

package com.hi.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.hi.myapplication.ui.airport.screen.AirportInfoPage
import com.hi.myapplication.ui.exchange.screen.ExchangeRatePage

import com.hi.myapplication.ui.theme.MyApplicationTheme
import com.hi.myapplication.ui.navigationbar.MyNavigationBar
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MyApplicationTheme(dynamicColor = false) {
                var selectItemIndex by remember {
                    mutableIntStateOf(0)
                }
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold(
                        bottomBar = {
                            MyNavigationBar(
                                selectedItemIndex = selectItemIndex) {
                                selectItemIndex = it
                            }
                        }
                    ) {
                        PaddedBox(innerPadding = it) {
                            when (selectItemIndex) {
                                0 -> {
                                    AirportInfoPage()
                                }

                                1 -> {
                                    ExchangeRatePage()
                                }

                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun PaddedBox(innerPadding: PaddingValues, content: @Composable () -> Unit) {
    Box() {
        content()
    }
}

