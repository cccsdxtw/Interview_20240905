//接資料用 匯率ＪＯＳＮ轉換

package com.hi.myapplication.domain.exchange.model

import com.google.gson.annotations.SerializedName
import kotlin.reflect.KProperty1
import kotlin.reflect.full.memberProperties

data class RateInfoItem(
    val data: Data
) {
    data class Data(
        @SerializedName("JPY")
        val jpy: Double = 1.0,
        @SerializedName("USD")
        val usd: Double = 1.0,
        @SerializedName("CNY")
        val cny: Double = 1.0,
        @SerializedName("EUR")
        val eur: Double = 1.0,
        @SerializedName("AUD")
        val aud: Double = 1.0,
        @SerializedName("KRW")
        val krw: Double = 1.0,
    ) {
        companion object {
            fun getCurrencies(): List<String> {
                return Data::class.memberProperties.map(KProperty1<Data, *>::name)
            }
        }
    }
}

