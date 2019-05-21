package com.juniar.ancodev.infomovie.di

import com.juniar.ancodev.infomovie.network.NetworkRepository
import com.juniar.ancodev.infomovie.network.NetworkService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
open class AppModule {

    @Provides
    @Singleton
    fun providesNetworkService(retrofit: Retrofit): NetworkService = retrofit.create(NetworkService::class.java)

    @Singleton
    @Provides
    open fun providesRepository(networkService: NetworkService) = NetworkRepository(networkService)
}