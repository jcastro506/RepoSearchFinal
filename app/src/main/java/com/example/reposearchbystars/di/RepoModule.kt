package com.example.reposearchbystars.di

import com.example.reposearchbystars.data.remote.RetrofitApi
import com.example.reposearchbystars.data.repository.RepoRepositoryImpl
import com.example.reposearchbystars.domain.repository.RepoRepository
import com.example.reposearchbystars.util.Common.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepoModule {

    @Provides
    @Singleton
    fun provideBeerApi() : RetrofitApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RetrofitApi::class.java)
    }


    @Provides
    @Singleton
    fun provideRepoRepository(api:RetrofitApi) : RepoRepository {
        return RepoRepositoryImpl(api)
    }

}