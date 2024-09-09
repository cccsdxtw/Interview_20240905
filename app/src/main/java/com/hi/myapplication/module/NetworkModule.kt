//網路中介

package com.hi.myapplication.module

import com.hi.myapplication.data.exchange.RateApiService
import com.hi.myapplication.data.exchange.RateRetrofitInstance
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    fun provideRateRetrofitApi(): RateApiService {
        return RateRetrofitInstance.api
    }

}