package com.example.basededatos

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class AdminSQL(
    context: Context?
) : SQLiteOpenHelper(context, "persona", null, 1) {
    override fun onCreate(base: SQLiteDatabase?) {
       val query =
           "CREATE TABLE persona (" +
                   "idPersona INTEGER PRIMARY KEY AUTOINCREMENT," +
                   "nombre VARCHAR(30)," +
                   "apellido VARCHAR(30)," +
                   "correo VARCHAR(50) );"
        base?.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }
}