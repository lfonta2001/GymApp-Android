package com.lfonta.gymapp.domain.repository

import com.lfonta.gymapp.domain.model.Routine

interface RoutineRepository {
    suspend fun getUserRoutines(userId: String): List<Routine>
    suspend fun saveRoutine(routine: Routine)
}