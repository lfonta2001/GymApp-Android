package com.lfonta.gymapp.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.lfonta.gymapp.domain.model.Recipe

@Dao
interface RecipeDao {
    @Insert
    fun insertRecipe(recipe: Recipe)

    @Query ("SELECT * FROM recipes WHERE recipe_id = :recipeId")
    fun queryRecipe(recipeId: String): List<Recipe>

    @Delete
    fun deleteRecipe(recipeId: String)
}