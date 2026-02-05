package com.lfonta.gymapp.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TokenBundle (
    val accessToken: String,
    val refreshToken: String
)

// REGISTRATION

@Serializable
data class ResRegistrationDto (
    @SerialName("user_id")
    val userId: String
)

@Serializable
data class PetRegistrationDto (
    val email: String,
    val password: String,
    val name: String
)

// LOGIN

@Serializable
data class PetLoginDto (
    val email: String,
    val password: String,
    @SerialName("remember-me") val rememberMe: Boolean
)

@Serializable
data class ResLoginDto (
    val userId: String,
    @SerialName("validation-tokens") val validationTokens: TokenBundle
)

// PASSWORD RESET

@Serializable
data class PetPasswordResetDto (
    val email: String
)

// CHANGE PASSWORD

@Serializable
data class PetChangePasswordDto (
    val password: String,
    @SerialName("new-password") val newPassword: String
)