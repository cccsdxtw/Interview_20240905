//接資料用 匯率ＡＰＩ


package com.hi.myapplication.data.exchange

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RateRetrofitInstance {
    private const val BASE_URL = "https://api.freecurrencyapi.com/"

    val api: RateApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(RateApiService::class.java)
    }
}