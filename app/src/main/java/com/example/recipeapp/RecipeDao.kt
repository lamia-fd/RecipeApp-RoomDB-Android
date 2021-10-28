package com.example.recipeapp

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface RecipeDao {



        @Query("select * from Recipe") fun getAllNote():List<Recipe>

        @Insert
        fun addRecipe(recipe:Recipe)

      //  @Query("delete from Recipe where id= :id") fun deleteNote(id: Int)
     //   @Query("UPDATE Recipe SET note =:note WHERE id=:id;") fun updateNote(id: Int, note:String)

}