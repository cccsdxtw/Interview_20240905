//接資料用 匯率ＡＰＩ


package com.hi.myapplication.data.exchange

import com.hi.myapplication.domain.exchange.model.RateInfoItem
import retrofit2.Response

interface RateRepository {
    suspend fun getFromApiResult(): Response<RateInfoItem>
}