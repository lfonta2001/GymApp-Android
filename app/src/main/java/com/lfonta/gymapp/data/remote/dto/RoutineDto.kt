package com.lfonta.gymapp.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RoutineDto(
    @SerialName("routine_id") val id: String,
    @SerialName("routine_title") val title: String,
    @SerialName("is_from_gym") val gymIsOwner: Boolean,
    @SerialName("author_id") val authorId: String,
    @SerialName("exercise_list") val exercises: List<ExerciseDto>,
    @SerialName("is_public") val public: Boolean,
    @SerialName("created_at") val creationTimestamp: Long,
    @SerialName("last_modified_at") val lastModifierTimestamp: Long
)