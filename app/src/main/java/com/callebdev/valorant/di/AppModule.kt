package com.callebdev.valorant.di

import com.callebdev.valorant.commons.Constants
import com.callebdev.valorant.data.remote.ValorantApi
import com.callebdev.valorant.data.repositories.ValorantRepositoryImpl
import com.callebdev.valorant.domain.repositories.ValorantRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideValorantApi(): ValorantApi =
        Retrofit.Builder().baseUrl(Constants.VALORANT_API_BASE_URL).addConverterFactory(GsonConverterFactory.create()).build().create(ValorantApi::class.java)

    @Provides
    @Singleton
    fun provideValorantRepository(valorantApi: ValorantApi): ValorantRepository = ValorantRepositoryImpl(valorantApi)
}
