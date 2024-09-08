//整理資料用 預留給有飛機ＡＰＩ時使用



//package com.hi.myapplication.domain.airport.usecase
//
//import com.hi.myapplication.domain.airport.model.AirportInfoItem
//import retrofit2.Response
//
//class GetAirportInfoResponseUseCase {
//    fun processResponse(response: Response<List<AirportInfoItem>>): List<AirportInfoItem> {
//        return if (response.isSuccessful) {
//            response.body() ?: emptyList()
//        } else {
//            emptyList()
//        }
//    }
//}