//選擇頁面按鈕資料組

package com.hi.myapplication.ui.navigationbar
import androidx.compose.ui.graphics.painter.Painter

data class MyBottomNavigationItem(
    val title: String,
    val selectedIcon: Painter,
    val unselectedIcon: Painter,
    val hasNews: Boolean,
    val badgeCount: Int? = null
)