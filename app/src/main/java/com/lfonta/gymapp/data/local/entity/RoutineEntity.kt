package com.lfonta.gymapp.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "routines")
data class RoutineEntity (
    @PrimaryKey val routineId: String,
    val ownerId: String,
    val title: String,
    val exercisesCount: Int
)