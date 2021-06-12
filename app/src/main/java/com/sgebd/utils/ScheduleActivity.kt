package com.sgebd.utils

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.sgebd.R
import org.json.JSONArray

class ScheduleActivity : AppCompatActivity() {
    lateinit var tvMLunes: TextView
    lateinit var tvMartes: TextView
    lateinit var tvMiercoles: TextView
    lateinit var tvJueves: TextView
    lateinit var tvViernes: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_schedule)

        tvMLunes=findViewById(R.id.Mlunes)
        tvMartes=findViewById(R.id.MMartes)
        tvMiercoles=findViewById(R.id.MMiercoles)
        tvJueves=findViewById(R.id.MJueves)
        tvViernes=findViewById(R.id.MViernes)

        val carga = intent.getStringExtra("seleccion")
        println(carga)
        val jsonmaterias=JSONArray(carga)
        val registro1=jsonmaterias.getJSONObject(0)
        val asignatura1=registro1.getString("materia")
        tvMLunes.text=asignatura1.toString()
        val registro2=jsonmaterias.getJSONObject(1)
        val asignatura2=registro2.getString("materia")
        tvMartes.text=asignatura2.toString()
        val registro3=jsonmaterias.getJSONObject(2)
        val asignatura3=registro3.getString("materia")
        tvMiercoles.text=asignatura3.toString()
        val registro4=jsonmaterias.getJSONObject(3)
        val asignatura4=registro4.getString("materia")
        tvJueves.text=asignatura4.toString()
        val registro5=jsonmaterias.getJSONObject(4)
        val asignatura5=registro5.getString("materia")
        tvViernes.text=asignatura5.toString()
    }

}