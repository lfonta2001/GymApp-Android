package com.lfonta.gymapp.core.constants

@JvmInline
value class ExerciseSpecificId (val value: String)

enum class BodyRegionLevel (val id: String) {
    UPPER ("upper"),
    CORE ("core"),
    LOWER ("lower")
}

enum class SubCategoryLevel (val value: Int) {
    // UPPER SUBCATEGORIES
    NECK(1),
    SHOULDERS(2),
    BICEPS(3),
    TRICEPS(4),
    FOREARMS(5),
    CHEST(6),

    // MEDIUM SUBCATEGORY
    ABDOMINAL(1),
    BACK(2),

    // LOWER SUBCATEGORY
    QUADS(1),
    ASS(2),
    POSTERIOR(3),
    CALVES(4)
}

data class ExerciseId(
     val train: BodyRegionLevel,
    val subCategory: SubCategoryLevel,
    val specific: ExerciseSpecificId
) {
    override fun toString(): String =
        "${train.id}-${subCategory.value}-${specific.value}"
}
