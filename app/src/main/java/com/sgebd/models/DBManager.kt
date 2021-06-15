package com.sgebd.models

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBManager (context: Context?,
                 name: String?,
                 factory: SQLiteDatabase.CursorFactory?,
                 version: Int): SQLiteOpenHelper(context, name, factory, version)
{
    override fun onCreate(db: SQLiteDatabase?) {
        TODO("Not yet implemented")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }
}