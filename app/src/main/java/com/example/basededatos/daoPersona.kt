package com.example.basededatos

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import kotlin.Exception

class daoPersona(
    val context: Context
) {
    private val database: AdminSQL = AdminSQL(context)
    var base: SQLiteDatabase = database.writableDatabase

    fun insertar(obj: persona): Boolean {
        val query =
            "INSERT INTO persona (nombre, apellido, correo) VALUES (" +
                    "${obj.nombre}," +
                    "${obj.apellido}," +
                    "${obj.correo} )"
        return try {
            base.execSQL(query)
            true
        } catch (e: Exception) {
            false
        }
    }
    fun obtenerUno(nombre: String): persona? {
        base = database.readableDatabase
        return try {
            val query =
                "SELECT * FROM persona WHERE nombre = '${nombre}'"
            val cursor = base.rawQuery(query, null)
            cursor.moveToFirst()
            val persona = persona(
                cursor.getString(1),
                cursor.getString(2),
                cursor.getString(3)
            )
            persona
        } catch (e: Exception) {
            null
        }
    }
}