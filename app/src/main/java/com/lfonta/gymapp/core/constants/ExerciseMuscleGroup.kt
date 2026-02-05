package com.lfonta.gymapp.core.constants

import com.lfonta.gymapp.R

enum class ExerciseGeneralCategory(val id: String) {
    ABDOMINAL("abdominal"),
    BACK("back"),
    CHEST("chest"),
    LEGS("legs"),
    SHOULDER("shoulder"),
}

fun ExerciseGeneralCategory.toStringRes(): Int =
    when (this) {
        ExerciseGeneralCategory.ABDOMINAL -> R.string.ec_abdominal
        ExerciseGeneralCategory.BACK -> R.string.ec_back
        ExerciseGeneralCategory.CHEST -> R.string.ec_chest
        ExerciseGeneralCategory.LEGS -> R.string.ec_legs
        ExerciseGeneralCategory.SHOULDER -> R.string.ec_shoulder
    }
