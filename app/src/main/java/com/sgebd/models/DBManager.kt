package com.sgebd.models

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.database.sqlite.SQLiteQuery
import android.text.Editable
import kotlin.jvm.Throws

open class DBManager (context: Context?,
                      name: String?,
                      factory: SQLiteDatabase.CursorFactory?,
                      version: Int): SQLiteOpenHelper(context, name, factory, version) {
    override fun onCreate(db: SQLiteDatabase?) {
        var sql = ""
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

            sql =
                "INSERT INTO materia (name, grade, evaluation) VALUES ('Fundamentos','Tercer_Seemestre','80')"

            it.execSQL(sql)

            sql = """
               CREATE TABLE alumno(
                    id INTEGER PRIMARY KEY NOT NULL,
                    name TEXT NOT NULL,
                    carrera TEXT NOT NULL,
                    semestre TEXT NOT NULL,
                    contrasena TEXT NOT NULL

            )
             """.trimIndent()

            sql =
                "INSERT INTO alumno (name, carrera, semestre, contrasena) VALUES ('Alex','Tics','8','1234')"

            sql = """
                CREATE TABLE inscripcion(
                    id INTEGER PRIMARY KEY NOT NULL,
                    name TEXT NOT NULL,
                    profesor TEX NOT NUll
        )
        """.trimIndent()
            sql="SELECT name FROM inscripcion WHERE id=1"
            sql="DELETE FROM inscripcion"
            it.execSQL(sql)

        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {}

    @Throws
    fun find(name: Editable? = null): ArrayList<Materia> {
        val db = readableDatabase

        var sql = "SELECT * FROM inscripcion"
        name?.let {
            if (it.isNotEmpty()) {
                sql += " WHERE name LIKE '%$it%'"
            }
        }

        val materias = ArrayList<Materia>()

        val cursor = db.rawQuery(sql, null)
        while (cursor.moveToNext()) {
            val materia = Materia(
                cursor.getInt(0),
                cursor.getString(1),
                cursor.getString(2)
            )

            materias.add(materia)
        }
        db.close()

        return materias
    }

    @Throws
    fun create(materia: Materia) {
        val db = writableDatabase
        var sql = ""
        sql = "INSERT INTO inscripcion(name,profesor) VALUES(?,?)"
        val compileStm = db.compileStatement(sql)
        compileStm.bindString(1,materia.name)
        compileStm.bindString(2,materia.teacher)

        compileStm.execute()
        db.close()
    }

}
