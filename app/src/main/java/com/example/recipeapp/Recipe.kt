package com.example.recipeapp

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Recipe")
class  Recipe(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id:Int=0,
    @ColumnInfo(name="title") var title: String?,
    @ColumnInfo(name="author") var author: String?,
    @ColumnInfo(name="ingredients") var ingredients: String?,
    @ColumnInfo(name="instructions") var instructions: String?
)