package com.sgebd.utils
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.sgebd.R
import com.sgebd.adapters.RecyclerInscripcionAdapter
import org.json.JSONArray
import org.json.JSONObject

class InscripcionActivity : AppCompatActivity() {
    lateinit var recyclerInscripcion : RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inscripcion)
        recyclerInscripcion=findViewById(R.id.recyclerInscripcion)

        var stringBD = intent.getStringExtra("bd")
        if(stringBD == null) {
            stringBD = resources.getString(R.string.jsonAlumnos)
        }

        val stringAlumno = intent.getStringExtra("alumno")

        val bd = JSONObject(stringBD)

        // Se obtiene el semestre
        val jsonAlumno = JSONObject(stringAlumno)
        val strSemestre = jsonAlumno.getString("semestre")



        // Se verifica si tiene kardex
        var jsonAlumnoMaterias = JSONArray()
        if( ! jsonAlumno.has("kardex")) {
            val admin = AdminBD()
            jsonAlumnoMaterias = admin.generaCalificaciones(stringBD, strSemestre)
            if(jsonAlumnoMaterias.length() > 0) {

                // Se colocan los resultados
                jsonAlumno.put("kardex",jsonAlumnoMaterias)

                val alumnos = bd.getJSONArray("alumnos")
                for(i in 0..alumnos.length()-1) {
                    val alumno = alumnos.getJSONObject(i)
                    if(alumno.getString("no_control").equals(jsonAlumno.getString("no_control"))) {
                        alumnos.remove(i)
                        alumnos.put(jsonAlumno)
                    }
                }

                // Colocamos el resultado en la UI
                recyclerInscripcion.adapter = RecyclerInscripcionAdapter(this, R.layout.row_reticula, jsonAlumnoMaterias, bd.getJSONArray("materias"))
                recyclerInscripcion.layoutManager = LinearLayoutManager(this)

                println("Nueva BD:\n$bd")

            } else {
                Toast.makeText(this,"Datos incorrectos", Toast.LENGTH_LONG).show()
            }
        } else {
            jsonAlumnoMaterias = jsonAlumno.getJSONArray("kardex")

            // Colocamos el resultado en la UI
            recyclerInscripcion.adapter = RecyclerInscripcionAdapter(this, R.layout.row_reticula, jsonAlumnoMaterias, bd.getJSONArray("materias"))
            recyclerInscripcion.layoutManager = LinearLayoutManager(this)

        }

        // Se agregan al intent los resultados
        val intent = Intent()
        intent.putExtra("bd", bd.toString())
        intent.putExtra("alumno", jsonAlumno.toString())
        //intent.putExtra("inscripcion",jsonInscripcion.toString())
        setResult(Activity.RESULT_OK,intent)
    }
}