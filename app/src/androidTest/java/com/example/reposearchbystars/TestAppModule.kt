package com.toprepos

import com.example.reposearchbystars.data.remote.RetrofitApi
import com.example.reposearchbystars.data.repository.FakeRepository
import com.example.reposearchbystars.data.repository.RepoRepositoryImpl
import com.example.reposearchbystars.domain.repository.RepoRepository
import com.example.reposearchbystars.util.Common
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton



//di class for testing
@Module
@InstallIn(SingletonComponent::class)
object TestAppModule {


    @Provides
    @Singleton
    fun provideBeerApi() : RetrofitApi {
        return Retrofit.Builder()
            .baseUrl(Common.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RetrofitApi::class.java)
    }


    @Provides
    @Singleton
    fun provideRepoRepository(api: RetrofitApi) : RepoRepository {
        return FakeRepository(api)
    }
}