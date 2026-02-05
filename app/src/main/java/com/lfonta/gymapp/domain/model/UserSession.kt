package com.lfonta.gymapp.domain.model

data class UserSession (
    val accessToken: String,
    val refreshToken: String
)