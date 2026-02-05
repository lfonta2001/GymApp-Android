package com.lfonta.gymapp.domain.repository

import com.lfonta.gymapp.data.remote.dto.*
import com.lfonta.gymapp.domain.model.UserRegistrationData
import com.lfonta.gymapp.domain.model.UserSession
import retrofit2.Response

interface AuthRepository {
    suspend fun register(body: UserRegistrationData)

    suspend fun login(body: UserRegistrationData): Result<UserSession>

    suspend fun refreshAccessToken(): Result<TokenBundle>

    suspend fun requestPasswordReset()

    suspend fun changePassword()

    suspend fun logout()

    suspend fun logOtherDeviceOut()

    suspend fun logMultipleDevicesOut()

}