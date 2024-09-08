//匯率頁面

package com.hi.myapplication.ui.exchange

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hi.myapplication.domain.exchange.usecase.CreateNewCurrencyMapUseCase
import com.hi.myapplication.domain.exchange.usecase.IntegrateResultToMapUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ExchangeRateViewModel @Inject constructor(
    private val integrateResultToMapUseCase: IntegrateResultToMapUseCase,
    private val createCurrencyMap: CreateNewCurrencyMapUseCase
) : ViewModel() {
    private val _rateList = MutableStateFlow(emptyMap<String, Double>())
    private val _displayList = MutableStateFlow(emptyMap<String, Double>())
    val displayList = _displayList.asStateFlow()
    private val _isRateCardEnabled = MutableStateFlow(false)
    val isRateCardEnabled = _isRateCardEnabled.asStateFlow()

    init {
        fetchCurrencyRate()
    }

    private fun fetchCurrencyRate() {
        viewModelScope.launch {
            val allRate: Map<String, Double> = integrateResultToMapUseCase.getResult()
            _rateList.value = allRate
            _displayList.value = allRate
            _isRateCardEnabled.value = true
        }
    }

    fun updateCurrencyAmounts(
        selectedCurrency: String,
        amount: Double = 0.0,
    ) {


        _displayList.value = createCurrencyMap.create(
            _displayList.value, _rateList.value, selectedCurrency, amount
        )
    }

}
