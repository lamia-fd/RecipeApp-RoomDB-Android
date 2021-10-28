package com.example.recipeapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch



class MainActivity : AppCompatActivity() {

     lateinit var newRecipe:List<Recipe>
    lateinit var rv:RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         rv=findViewById(R.id.rvMain)
        newRecipe= arrayListOf()

            newRecipe = RecipeDatabase.getInstance(applicationContext).RecipeDao().getAllNote()



        rv.adapter= recycler(newRecipe)
        rv.layoutManager= LinearLayoutManager(applicationContext)

        rv.scrollToPosition(newRecipe.size-1)
      //  getAllRecipe()




    }


    fun adduser(view: android.view.View) {

        intent = Intent(applicationContext, MainActivity2::class.java)
        startActivity(intent)

    }
    fun getAllRecipe(){

        CoroutineScope(IO).launch{
            newRecipe = RecipeDatabase.getInstance(applicationContext).RecipeDao().getAllNote()

        }

        rv.adapter= recycler(newRecipe)
        rv.layoutManager= LinearLayoutManager(applicationContext)

        rv.scrollToPosition(newRecipe.size-1)
    }

}


