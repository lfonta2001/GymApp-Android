package com.lfonta.gymapp.domain.model

import com.lfonta.gymapp.core.constants.UserRole
import java.time.Instant

data class User (
    val userId: String,
    val name: String,
    val gender: String,
    val email: String,
    val phone: String,
    val role: UserRole,
    val gymId: String? = null,
    val createdAt: Instant,
    val lastModifierAt: Instant,
    val height: Int? = null,
    val weight: Int? = null,
    val dateOfBirth: Instant,
    val age: Int? = null
)
