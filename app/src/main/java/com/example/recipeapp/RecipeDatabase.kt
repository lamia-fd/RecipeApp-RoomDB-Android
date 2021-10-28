package com.example.recipeapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Recipe::class],version = 1,exportSchema = false)
abstract class RecipeDatabase: RoomDatabase() {


    companion object {

        var instance: RecipeDatabase? = null

        fun getInstance(context: Context): RecipeDatabase {
            if (instance != null) {
                return instance as RecipeDatabase

            }
            instance = Room.databaseBuilder(
                context,
                RecipeDatabase::class.java,
                "RecipeDB"
            ).run { allowMainThreadQueries() }.build()

            return instance as RecipeDatabase

        }
    }
    abstract fun RecipeDao():RecipeDao
}