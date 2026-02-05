package com.lfonta.gymapp.domain.repository

import com.lfonta.gymapp.domain.model.Recipe

interface RecipeRepository {
    suspend fun getUserRecipe(userId: String): List<Recipe>
    suspend fun saveRecipe(recipe: Recipe)
}