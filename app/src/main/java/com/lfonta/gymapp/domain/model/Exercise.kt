package com.lfonta.gymapp.domain.model

import com.lfonta.gymapp.core.constants.ExerciseGeneralCategory

data class Exercise (
    val id: String,
    val name: String,
    val group: Set<ExerciseGeneralCategory>,
    val defaultMediaId: String,
    val defaultDescriptionId: String,
    val tags: String,
    val qrCode: String
)