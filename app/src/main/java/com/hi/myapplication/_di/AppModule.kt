//APP中介

package com.hi.myapplication._di

import com.hi.myapplication.data.exchange.RateApiService
import com.hi.myapplication.data.exchange.RateRepository
import com.hi.myapplication.data.exchange.RateRepositoryImpl
import com.hi.myapplication.domain.exchange.usecase.CreateNewCurrencyMapUseCase
import com.hi.myapplication.domain.exchange.usecase.GetRateResponseUseCase

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    @Singleton
    fun provideRateRepository(api: RateApiService): RateRepository {
        return RateRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideCreateNewCurrencyMapUseCase(): CreateNewCurrencyMapUseCase {
        return CreateNewCurrencyMapUseCase()
    }


    @Provides
    @Singleton
    fun provideGetRateResponseUseCase(): GetRateResponseUseCase {
        return GetRateResponseUseCase()
    }

//    @Provides
//    @Singleton
//    fun provideGetAirportInfoResponseUseCase(): GetAirportInfoResponseUseCase {
//        return GetAirportInfoResponseUseCase()
//    }


    //    @Provides
//    @Singleton
//    fun provideAirportRepository(api: AirportApiService): AirportRepository {
//        return AirportRepositoryImpl(api)
//    }

}
