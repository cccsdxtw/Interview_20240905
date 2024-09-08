//接資料用 匯率ＡＰＩ


package com.hi.myapplication.data.exchange


import com.hi.myapplication.domain.exchange.model.RateInfoItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface RateApiService {
    @GET("v1/latest")
    suspend fun getRate(
        @Header("apiKey") apiKey: String
    ): Response<RateInfoItem>
}