package com.example.test

import android.os.Bundle
import android.os.StrictMode
import android.os.StrictMode.ThreadPolicy
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.test.models.UserModel
import com.example.test.repository.UserRepository
import com.google.android.material.floatingactionbutton.FloatingActionButton


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val policy = ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fab = findViewById<FloatingActionButton>(R.id.floatingActionButton)
        val editTextTextEmailAddress = findViewById<TextView>(R.id.editTextTextEmailAddress)
        val editTextTextPassword = findViewById<TextView>(R.id.editTextTextPassword)
        val editTextDate = findViewById<TextView>(R.id.editTextDate)
        fab.setOnClickListener {
            val userModel = UserModel(
                "John@gmail.com",
                "johnd",
            )
            Log.i("userModel", "${userModel}")
            try {
                val user = UserRepository.postUser(userModel)
                Log.e("userResponse", "$user")

                Toast.makeText(this, "Chegou aqui", Toast.LENGTH_LONG).show()

            } catch (e: Throwable) {
                Log.e("error", "$e")

            }
        }
    }
}