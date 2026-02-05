package com.lfonta.gymapp.domain.usecase.basic

import androidx.datastore.dataStore
import com.lfonta.gymapp.domain.model.UserRegistrationData
import com.lfonta.gymapp.domain.model.UserSession
import com.lfonta.gymapp.domain.repository.AuthRepository
import javax.inject.Inject

class RegisterAndLoginUserUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(registrationData: UserRegistrationData, loginData:
    UserRegistrationData): UserSession {
        authRepository.register(registrationData)
        val res =  authRepository.login(loginData)
        var data: UserSession = null
        res.onSuccess { d -> data = d}
        return data
    }
}