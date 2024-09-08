//整理資料用 匯率ＡＰＩ

package com.hi.myapplication.domain.exchange.usecase

import com.hi.myapplication.data.exchange.RateRepository
import com.hi.myapplication.domain.exchange.model.RateInfoItem
import retrofit2.Response
import javax.inject.Inject

class FetchCurrencyRateUseCase @Inject constructor(
    private val repository: RateRepository,
) {
    suspend fun execute(): Response<RateInfoItem> {
        return repository.getFromApiResult()
    }
}