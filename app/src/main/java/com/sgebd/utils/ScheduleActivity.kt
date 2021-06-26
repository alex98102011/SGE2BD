package com.sgebd.utils

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.sgebd.R
import com.sgebd.models.DBManager
import org.json.JSONArray
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class ScheduleActivity: AppCompatActivity(){
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
    lateinit var dbManager : DBManager

    override fun onCreate(savedInstanceState: Bundle?)  {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_schedule)

        tvMLunes=findViewById(R.id.Mlunes)
        tvMartes=findViewById(R.id.MMartes)
        tvMartes2 = findViewById(R.id.M2Martes)
        tvMiercoles=findViewById(R.id.MMiercoles)
        tvJueves=findViewById(R.id.MJueves)
        tvJueves2 = findViewById(R.id.M2Jueves)
        tvViernes=findViewById(R.id.MViernes)

        dbManager = DBManager(
            this,
            resources.getString(R.string.db_name),
            null,
            resources.getInteger(R.integer.db_version)
        )
    sql= ""
    materia="SELECT name FROM inscripcion WHERE id=1"
    prof= "SELECT profesor FROM inscripcion WHERE id=1"


val db: SQLiteDatabase= dbManager.readableDatabase

        val cursor= db.rawQuery(
            "SELECT name FROM inscripcion",
            null
        )
        val borrar= db.rawQuery("DELETE FROM inscripcion",
        null)
val matins= arrayListOf<String>()
   if(cursor.moveToFirst()){
       do{
        matins.add(cursor.getString(0).toString())
       }while(cursor.moveToNext())
   }

/*
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
*/
        val carga = intent.getStringExtra("seleccion")
        println(carga)
        val jsonmaterias=JSONArray(carga)
        val registro1=jsonmaterias.getJSONObject(0)
        val asignatura1=registro1.getString("materia")
        tvMLunes.text=matins[1]
        /*if(jsonmaterias.length()>=2) {
            val registro2 = jsonmaterias.getJSONObject(1)
            val asignatura2 = registro2.getString("materia")*/
            tvMartes.text =matins[2]
        /*}else{
            tvMartes.text="Fundamentos de Investigacion"
        }
        if(jsonmaterias.length()>=3) {
            val registro3 = jsonmaterias.getJSONObject(2)
            val asignatura3 = registro3.getString("materia")*/
            tvMiercoles.text =matins[3]
        /*}else{
            tvMiercoles.text ="Sin seleccion"
        }
        if(jsonmaterias.length()>=4) {
            val registro4 = jsonmaterias.getJSONObject(3)
            val asignatura4 = registro4.getString("materia")*/
            tvJueves.text =matins[4]
        /*}else{
            tvJueves.text ="Sin seleccion"
        }
        if(jsonmaterias.length()>=5) {
            val registro5 = jsonmaterias.getJSONObject(4)
            val asignatura5 = registro5.getString("materia")*/
            tvViernes.text =matins[5]
        /*}else {
            tvViernes.text = "Sin seleccion"
        }
        if(jsonmaterias.length()>=6) {
            val registro6 = jsonmaterias.getJSONObject(5)
            val asignatura6 = registro6.getString("materia")*/
            tvMartes2.text = matins[6].toString()
        /*}else{
            tvMartes2.text ="Servicio Social"
        }
        if(jsonmaterias.length()>=7) {
            val registro7 = jsonmaterias.getJSONObject(6)
            val asignatura7 = registro7.getString("materia")*/
            tvJueves2.text =matins[7].toString()
        /*}else{
            tvJueves2.text = "Tutoria"
        }*/
    }

}