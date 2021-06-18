package com.sgebd.utils

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.sgebd.R
import org.json.JSONArray

class ScheduleActivity : AppCompatActivity() {
    var sql = ""
    var materia=""
    var prof=""

    lateinit var tvMLunes: TextView
    lateinit var tvMartes: TextView
    lateinit var tvMartes2 : TextView
    lateinit var tvMiercoles: TextView
    lateinit var tvJueves: TextView
    lateinit var tvJueves2: TextView
    lateinit var tvViernes: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_schedule)

        tvMLunes=findViewById(R.id.Mlunes)
        tvMartes=findViewById(R.id.MMartes)
        tvMartes2 = findViewById(R.id.M2Martes)
        tvMiercoles=findViewById(R.id.MMiercoles)
        tvJueves=findViewById(R.id.MJueves)
        tvJueves2 = findViewById(R.id.M2Jueves)
        tvViernes=findViewById(R.id.MViernes)


        sql= "INSERT INTO incripcion (name, profesor) VALUES ('Fundamentos','Carlos L')"
        materia="SELECT name FROM inscripcion WHERE id=1"
        prof= "SELECT profesor FROM inscripcion WHERE id=1"

        sql= "INSERT INTO incripcion (name, profesor) VALUES ('POO','Lorena R')"
        materia="SELECT name FROM inscripcion WHERE id=2"
        prof= "SELECT profesor FROM inscripcion WHERE id=2"

        sql= "INSERT INTO incripcion (name, profesor) VALUES ('Matematicas','Ramiro G')"
        materia="SELECT name FROM inscripcion WHERE id=3"
        prof= "SELECT profesor FROM inscripcion WHERE id=3"

        sql= "INSERT INTO incripcion (name, profesor) VALUES ('Investigación','Margarita H')"
        materia="SELECT name FROM inscripcion WHERE id=4"
        prof= "SELECT profesor FROM inscripcion WHERE id=4"

        sql= "INSERT INTO incripcion (name, profesor) VALUES ('Programación','Maria V')"
        materia="SELECT name FROM inscripcion WHERE id=5"
        prof= "SELECT profesor FROM inscripcion WHERE id=5"

        sql= "INSERT INTO incripcion (name, profesor) VALUES ('Sistemas','Martin O')"
        materia="SELECT name FROM inscripcion WHERE id=6"
        prof= "SELECT profesor FROM inscripcion WHERE id=6"

        val carga = intent.getStringExtra("seleccion")
        println(carga)
        val jsonmaterias=JSONArray(carga)
        val registro1=jsonmaterias.getJSONObject(0)
        val asignatura1=registro1.getString("materia")
        tvMLunes.text=asignatura1.toString()
        if(jsonmaterias.length()>=2) {
            val registro2 = jsonmaterias.getJSONObject(1)
            val asignatura2 = registro2.getString("materia")
            tvMartes.text = asignatura2.toString()
        }else{
            tvMartes.text="Fundamentos de Investigacion"
        }
        if(jsonmaterias.length()>=3) {
            val registro3 = jsonmaterias.getJSONObject(2)
            val asignatura3 = registro3.getString("materia")
            tvMiercoles.text = asignatura3.toString()
        }else{
            tvMiercoles.text ="Sin seleccion"
        }
        if(jsonmaterias.length()>=4) {
            val registro4 = jsonmaterias.getJSONObject(3)
            val asignatura4 = registro4.getString("materia")
            tvJueves.text = asignatura4.toString()
        }else{
            tvJueves.text ="Sin seleccion"
        }
        if(jsonmaterias.length()>=5) {
            val registro5 = jsonmaterias.getJSONObject(4)
            val asignatura5 = registro5.getString("materia")
            tvViernes.text = asignatura5.toString()
        }else {
            tvViernes.text = "Sin seleccion"
        }
        if(jsonmaterias.length()>=6) {
            val registro6 = jsonmaterias.getJSONObject(5)
            val asignatura6 = registro6.getString("materia")
            tvMartes2.text = asignatura6.toString()
        }else{
            tvMartes2.text ="Servicio Social"
        }
        if(jsonmaterias.length()>=7) {
            val registro7 = jsonmaterias.getJSONObject(6)
            val asignatura7 = registro7.getString("materia")
            tvJueves2.text = asignatura7.toString()
        }else{
            tvJueves2.text = "Tutoria"
        }
    }

}