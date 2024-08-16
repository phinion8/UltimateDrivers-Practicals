package com.priyanshu.ultimatedrivers.di

import com.priyanshu.ultimatedrivers.data.remote.ApiService
import com.priyanshu.ultimatedrivers.data.repositories.ApiRepositoryImpl
import com.priyanshu.ultimatedrivers.domain.repositories.ApiRepository
import com.priyanshu.ultimatedrivers.domain.repositories.LocalRepository
import com.priyanshu.ultimatedrivers.domain.usecases.remote.ApiUseCase
import com.priyanshu.ultimatedrivers.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteModule {

    @Provides
    @Singleton
    fun provideApiService(): ApiService {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
        return Retrofit.Builder()
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constants.BASE_URL)
            .build()
            .create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideApiRepository(apiService: ApiService): ApiRepository {
        return ApiRepositoryImpl(apiService)
    }

    @Provides
    @Singleton
    fun provideApiUseCase(repository: ApiRepository, localRepository: LocalRepository): ApiUseCase {
        return ApiUseCase(repository,localRepository)
    }

}