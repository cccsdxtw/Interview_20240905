//整理資料用 預留給有飛機ＡＰＩ時使用



//package com.hi.myapplication.domain.airport.usecase
//
//import com.hi.myapplication.data.airport.AirportRepository
//import com.hi.myapplication.domain.airport.model.AirportInfoItem
//import retrofit2.Response
//import javax.inject.Inject
//
//class FetchAirportInfoUseCase @Inject constructor(private val repository: AirportRepository) {
//    suspend fun execute(currentFlightType: String): Response<List<AirportInfoItem>> {
//        return repository.getThisTypeFlightInfo(currentFlightType)
//    }
//}