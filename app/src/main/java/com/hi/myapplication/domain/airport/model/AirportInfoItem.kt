//接資料用 飛行ＪＯＳＮ轉換

package com.hi.myapplication.domain.airport.model

import com.google.gson.annotations.SerializedName


data class AirportInfoItem(
    //預估時間
    @SerializedName("expectTime")
    val expectTime: String? = "00:10",
    //實際時間
    @SerializedName("realTime")
    val realTime: String? = "00:02",
    //登機門 如果是空的 視為抵達
    @SerializedName("airBoardingGate")
    val airBoardingGate: String? = "123",
    //飛行狀態
    @SerializedName("airFlyStatus")
    val airFlyStatus: String? = "123",
    //航空公司名字
    @SerializedName("airLineName")
    val airLineName: String? = "123",
    //班機號碼
    @SerializedName("airLineNum")
    val airLineNum: String? = "123",
    //機場簡稱
    @SerializedName("upAirportCode")
    val upAirportCode: String? = "123",
    //機場名稱
    @SerializedName("upAirportName")
    val upAirportName: String? = "123",
) {
    val status: AirportStatus get() = AirportStatus.fromValue(""+airFlyStatus)

}