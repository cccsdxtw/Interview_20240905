//辨識飛行狀態的顏色

package com.hi.myapplication.domain.airport.model

import com.hi.myapplication.R


enum class AirportStatus(val color: Int, val value: String) {
    Arrived(R.color.teal_700, "抵達Arrived"),
    OnTime(R.color.blue, "準時On Time"),
    Unknown(R.color.red, "未知狀態");

    companion object {
        fun fromValue(value: String): AirportStatus {
            return entries.find {
                //抓value出來比對 是否有在資料中
                it.value == value
            }
                //如果不符合上面狀態 給予未知
                ?: Unknown
        }
    }
}