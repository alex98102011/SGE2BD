package com.sgebd.utils

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.sgebd.R

class MainActivity : AppCompatActivity() {
    lateinit var editNoControl : EditText
    lateinit var editPass : EditText
    lateinit var btnAcceder : Button
    lateinit var btnRegistrar : Button
    lateinit var btnInscripcion: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editNoControl = findViewById<EditText>(R.id.editNoControl)
        editPass = findViewById<EditText>(R.id.editContrasenia)
        btnAcceder = findViewById<Button>(R.id.btnAcceder)
        btnRegistrar = findViewById<Button>(R.id.btnRegistrar)


    }
}