//選擇頁面按鈕

package com.hi.myapplication.ui.navigationbar

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hi.myapplication.R

@Composable
fun MyNavigationBar(
    selectedItemIndex: Int,
    onItemSelected: (Int) -> Unit,
) {
    val items: List<MyBottomNavigationItem> = listOf(
        MyBottomNavigationItem(
            title = "航班",
            selectedIcon = painterResource(id = R.mipmap.flights_selected),
            unselectedIcon = painterResource(id = R.mipmap.flights),
            hasNews = false
        ),
        MyBottomNavigationItem(
            title = "匯率",
            selectedIcon = painterResource(id = R.mipmap.exchange_rate_selected),
            unselectedIcon = painterResource(id = R.mipmap.exchange_rate),
            hasNews = false,
        ),
    )
    Row( modifier = Modifier.padding(10.dp,0.dp,10.dp,0.dp)) {
        Row(
            modifier = Modifier
                .clip(RoundedCornerShape(17.dp))
        ) {
            NavigationBar(
                containerColor = MaterialTheme.colorScheme.onBackground
            ) {
                items.forEachIndexed { index, item ->
                    NavigationBarItem(
                        selected = false,
                        onClick = {
                            onItemSelected(index) // Call the callback function to update selectedItemIndex
                        },
                        label = {
                            Text(text = item.title)
                        },
                        alwaysShowLabel = true,
                        icon = {
                            Image(
                                modifier = Modifier
                                    .align(Alignment.CenterVertically)
                                    .clip(RectangleShape),
                                painter = if (index == selectedItemIndex) {
                                    item.selectedIcon
                                } else item.unselectedIcon,
                                contentDescription = item.title,
                            )
                        },
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .clip(RectangleShape)
                    )
                }
            }

        }

    }
}


@Preview
@Composable
private fun Test() {
    MyNavigationBar(0, onItemSelected = {})
}




