package com.lfonta.gymapp.data.local.dao

import androidx.room.Dao
import androidx.room.*
import com.lfonta.gymapp.data.local.entity.RoutineEntity

@Dao
interface RoutineDao {
    @Query("SELECT * FROM routines WHERE ownerId = :ownerId LIMIT :limit")
    suspend fun getMultipleRoutines(ownerId: String, limit: Int): List<RoutineEntity>

    @Query("SELECT * FROM routines WHERE routineId = :rid")
    suspend fun getRoutine(rid: String): RoutineEntity
}