package com.lfonta.gymapp.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.lfonta.gymapp.data.remote.services.AuthApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class) // Le dice a Hilt que esto existe mientras la app este viva
object NetworkModule {

    private const val BASE_URL = "https://gymapp.lfonta.com/api"

    val client = OkHttpClient.Builder()
        .addInterceptor(BasicHeadersInterceptor())
        .build()

    @Provides
    @Singleton
    fun provideRetrofit(json: Json): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
            .build()
    }

    @Provides
    @Singleton
    fun provideAuthApiService(retrofit: Retrofit): AuthApiService {
        return retrofit.create(AuthApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideUsersApiService(retrofit: Retrofit): UserApiService {
        return retrofit.create(UserApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideGymApiService(retrofit: Retrofit): GymApiService {
        return retrofit.create(GymApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideRoutineApiService(retrofit: Retrofit): RoutineApiService {
        return retrofit.create(RoutineApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideRecipieApiService(retrofit: Retrofit): RecipieApiService {
        return retrofit.create(RecipeApiService::class.java)
    }
}
