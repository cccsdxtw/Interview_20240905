//接資料用 預留給有飛機ＡＰＩ時使用



//package com.hi.myapplication.data.airport
//
//import com.hi.myapplication.domain.airport.model.AirportInfoItem
//import retrofit2.Response
//
//class AirportRepositoryImpl(private val apiService: AirportApiService) : AirportRepository {
//    override suspend fun getThisTypeFlightInfo(currentFlightType: String): Response<List<AirportInfoItem>> {
//        return apiService.getFlightAllInfo(currentFlightType)
//    }
//}