//整理資料用 匯率ＡＰＩ 數值

package com.hi.myapplication.domain.exchange.usecase

import javax.inject.Inject

class IntegrateResultToMapUseCase @Inject constructor(
    private val fetchCurrencyRateUseCase: FetchCurrencyRateUseCase,
    private val getRateResponseUseCase: GetRateResponseUseCase
) {
    suspend fun getResult(): Map<String, Double> {
        val response = fetchCurrencyRateUseCase.execute()
        return getRateResponseUseCase.convertResponseToMap(response)
            .mapValues { (_, value) -> value as? Double ?: 1.0 }
    }
}