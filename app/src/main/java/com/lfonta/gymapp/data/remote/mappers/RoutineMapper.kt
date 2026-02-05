package com.lfonta.gymapp.data.remote.mappers

import com.lfonta.gymapp.data.local.entity.RoutineEntity
import com.lfonta.gymapp.data.remote.dto.RoutineDto
import com.lfonta.gymapp.domain.model.OwnerInfo
import com.lfonta.gymapp.domain.model.Routine

fun RoutineDto.toDomain(): Routine {
    val owner = if (this.gymIsOwner) {
         // TODO Hacer que llame a alguna de las apis, dependiendo si es gym o user
    } else {

    }
    return Routine(
        id = this.id,
        ownerInfo = OwnerInfo(id = "owner.id", name = "owner.name", isGym = this.gymIsOwner),
        title = this.title,
        public = this.public,
        exercises = this.exercises.map(it.toDomain()),
        usesTimer = true,
        distribution = true,
        createdAt = this.creationTimestamp,
        lastModifiedAt = this.lastModifierTimestamp
    )
}

fun Routine.toDto(): RoutineDto {
    return RoutineDto(
        id = this.id,
        title = this.title,
        gymIsOwner = this.ownerInfo.isGym,
        authorId = this.ownerInfo.id,
        exercises = this.exercises.map(it.toDto()),
        public = this.public,
        creationTimestamp = this.createdAt,
        lastModifierTimestamp = this.lastModifiedAt
    )
}

fun Routine.toEntity(): RoutineEntity {
    return RoutineEntity(
        routineId = this.id,
        ownerId = this.ownerInfo.id,
        title = this.title,
        exercisesCount = this.exercises.count()
    )
}