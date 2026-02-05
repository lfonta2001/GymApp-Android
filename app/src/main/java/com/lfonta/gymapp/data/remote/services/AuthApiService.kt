package com.lfonta.gymapp.data.remote.services

import com.lfonta.gymapp.data.remote.dto.*
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.POST

interface AuthApiService {
    // Public endpoints
    @POST("public/register")
    suspend fun register(@Body body: PetRegistrationDto): Response<ResRegistrationDto>

    @POST("public/login")
    suspend fun login(@Body body: PetLoginDto): Response<ResLoginDto>

    @POST("public/refresh")
    suspend fun refreshAccessToken(): Response<TokenBundle>

    @POST("public/request-password-reset")
    suspend fun requestPasswordReset(@Body body: PetPasswordResetDto)

    // Private endpoints
    @POST("private/change-password")
    suspend fun changePassword()

    @POST("private/logout")
    suspend fun logout()

    @DELETE("private/active-devices/{devId}")
    suspend fun logOtherDeviceOut()

    @DELETE("private/active-devices")
    suspend fun logMultipleDevicesOut()

}