package com.example.fetchapp.di

import com.example.fetchapp.data.FetchAPIService
import com.example.fetchapp.data.FetchRepository
import com.example.fetchapp.data.FetchRepositoryImpl
import com.example.fetchapp.utils.Constants
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
    fun provideFetchApi(): FetchAPIService {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(FetchAPIService::class.java)
    }

    @Provides
    @Singleton
    fun provideWeatherRepository(api: FetchAPIService): FetchRepository {
        return FetchRepositoryImpl(api)
    }


}