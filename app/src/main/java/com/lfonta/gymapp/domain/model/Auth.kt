package com.lfonta.gymapp.domain.model

data class UserRegistrationData (
    val email: String,
    val username: String,
    val password: String
)

data class UserLoginData (
    val email: String,
    val password: String
)