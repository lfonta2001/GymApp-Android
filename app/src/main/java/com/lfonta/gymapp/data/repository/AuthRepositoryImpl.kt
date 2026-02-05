package com.lfonta.gymapp.data.repository

import com.lfonta.gymapp.data.remote.dto.auth.*
import com.lfonta.gymapp.data.remote.services.AuthApiService
import com.lfonta.gymapp.domain.model.UserSession
import com.lfonta.gymapp.domain.repository.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val authApiService: AuthApiService
): AuthRepository {
    override suspend fun register(body: PetRegistrationDto) {
        try {
            val response = authApiService.register(body)
            if (response.isSuccessful) {
                val resRegister = response.body()!!


            } else {

            }
        } catch (e: Exception) {

        }
    }



    override suspend fun login(body: PetLoginDto): Result<UserSession> {
        return try {
            val response = authApiService.login(body)
            if (response.isSuccessful) {
                val resLogin = response.body()!!
                val userSession = resLogin.toDomain()
                userSession.save()
                Result.success(userSession)
            } else {
                TODO("Devolver error para que diga credenciales erroneas y que vuelvan a intentar")
                Result.failure<Exception>(Exception("Login failed"))
            }
        } catch (e: Exception) {
            Result.failure<Exception>(e)
        }
    }
}