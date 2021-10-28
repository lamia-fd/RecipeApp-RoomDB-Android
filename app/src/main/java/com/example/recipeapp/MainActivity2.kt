package com.example.recipeapp

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch


class MainActivity2 : AppCompatActivity() {
   lateinit var newRecipe:List<Recipe>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


        newRecipe= arrayListOf()
        val title = findViewById<EditText>(R.id.editTextTextPersonName2)
        val author = findViewById<EditText>(R.id.editTextTextPersonName3)
        val inge = findViewById<EditText>(R.id.editTextTextPersonName4)
        val ins = findViewById<EditText>(R.id.editTextTextPersonName5)
        val savebtn = findViewById<Button>(R.id.button)

        savebtn.setOnClickListener {
            if(title.text.isNotBlank()&& author.text.isNotBlank()&& inge.text.isNotBlank()&&ins.text.isNotBlank()) {


                var r = Recipe(
                    0,
                    title.text.toString(),
                    author.text.toString(),
                    inge.text.toString(),
                    ins.text.toString()
                )
                CoroutineScope(IO).launch {
                    RecipeDatabase.getInstance(applicationContext).RecipeDao().addRecipe(r)
                }
                Toast.makeText(applicationContext, "Save Success!", Toast.LENGTH_SHORT).show()
           }else{
               Toast.makeText(applicationContext, "all fields are required", Toast.LENGTH_SHORT).show()

            }

        }
    }



    fun viewreceipe(view: android.view.View) {
        intent = Intent(applicationContext, MainActivity::class.java)
        startActivity(intent)
    }


}