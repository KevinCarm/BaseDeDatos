package com.example.basededatos

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import java.lang.Exception

class daoPersona(
    val context: Context
) {
    private val database: AdminSQL = AdminSQL(context)
    var base: SQLiteDatabase = database.writableDatabase

    fun insertar(obj: persona): Boolean{
        val query =
            "INSERT INTO persona (nombre, apellido, correo) VALUES (" +
                    "${obj.nombre}," +
                    "${obj.apellido}," +
                    "${obj.correo} )"
        return try {
            base.execSQL(query)
            true
        }catch (e: Exception){
            false
        }
    }
}