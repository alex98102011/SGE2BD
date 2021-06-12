package com.sgebd.utils

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.sgebd.R

class MenuActivity : AppCompatActivity() {
    lateinit var btnKardex : Button
    lateinit var btnHorario : Button
    lateinit var btnReticula : Button
    lateinit var btnPersonales : Button
    lateinit var btnInscripcion: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)


        btnKardex = findViewById(R.id.btnKardex)
        btnHorario = findViewById(R.id.btnHorario)
        btnReticula = findViewById(R.id.btnReticula)
        btnPersonales = findViewById(R.id.btnPersonales)
        btnInscripcion=findViewById(R.id.btnInscripcion)


        btnKardex.setOnClickListener {  }

    }
}