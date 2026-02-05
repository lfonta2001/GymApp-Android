package com.lfonta.gymapp.data.local.dao

import androidx.room.*
import com.lfonta.gymapp.domain.model.Exercise

@Dao
interface ExerciseDao {
    @Insert
    fun insertExercise(exercise: Exercise)

    @Query("SELECT * FROM exercises WHERE exercise_id = :exerciseId LIMIT 1")
    fun queryExercise(exerciseId: String): Exercise?

    @Delete
    fun deleteExercise(ownerId: String, exerciseId: String)

}