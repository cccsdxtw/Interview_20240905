//接資料用 預留給有飛機ＡＰＩ時使用



//package com.hi.myapplication.data.airport
//
//import retrofit2.Retrofit
//import retrofit2.converter.gson.GsonConverterFactory
//
//
//object AirportRetrofitInstance {
//    private const val BASE_URL = ""
//
//    val api: AirportApiService by lazy {
//        Retrofit.Builder()
//            .baseUrl(BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build().create(AirportApiService::class.java)
//    }
//}