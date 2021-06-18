package com.sgebd.models

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import java.lang.NullPointerException

class DBManager (context: Context?,
                 name: String?,
                 factory: SQLiteDatabase.CursorFactory?,
                 version: Int): SQLiteOpenHelper(context, name, factory, version)
{
    override fun onCreate(db: SQLiteDatabase?) {
        var sql = ""
        var materia=""
        var prof=""
        db?.let {
            sql = """
                CREATE TABLE materia(
                    id INTEGER PRIMARY KEY NOT NULL,
                    name TEXT NOT NULL,
                    grade  TEXT NOT NULL,
                    evaluation TEXT NOT NULL
           
            )
            """
            it.execSQL(sql)

            sql= "INSERT INTO materia (name, grade, evaluation) VALUES ('Fundamentos','Tercer_Seemestre','80')"

            it.execSQL(sql)

            sql="""
               CREATE TABLE alumno(
                    id INTEGER PRIMARY KEY NOT NULL,
                    name TEXT NOT NULL,
                    carrera TEXT NOT NULL,
                    semestre TEXT NOT NULL,
                    contrasena TEXT NOT NULL

            )
             """.trimIndent()

            sql= "INSERT INTO alumno (name, carrera, semestre, contrasena) VALUES ('Alex','Tics','8','1234')"

            sql="""
                CREATE TABLE inscripcion(
                    id INTEGER PRIMARY KEY NOT NULL,
                    name TEXT NOT NULL,
                    profesor TEX NOT NUll
        )
        """.trimIndent()

            sql= "INSERT INTO incripcion (name, profesor) VALUES ('Fundamentos','Carlos L')"
            materia="SELECT name FROM inscripcion WHERE id=1"
            prof= "SELECT profesor FROM inscripcion WHERE id=1"
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {}
}