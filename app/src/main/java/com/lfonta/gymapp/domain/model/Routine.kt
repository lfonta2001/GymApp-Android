package com.lfonta.gymapp.domain.model

data class Routine(
    val id: String,
    val ownerInfo: OwnerInfo,
    val title: String,
    val public: Boolean,
    val exercises: List<Exercise>,
    val usesTimer: Boolean,
    val distribution: Boolean, // TODO Cambiar el tipo para que mapee reps/sets/tiempos
    val createdAt: Long,
    val lastModifiedAt: Long
)

data class OwnerInfo(
    val id: String,
    val name: String,
    val isGym: Boolean
)