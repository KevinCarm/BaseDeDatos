package com.example.basededatos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText

class ver_persona : AppCompatActivity() {
    private lateinit var nombre: EditText
    private lateinit var apellido: EditText
    private lateinit var correo: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ver_persona)
        nombre = findViewById(R.id.txtNombreView)
        apellido = findViewById(R.id.txtApellidoView)
        correo = findViewById(R.id.txtCorreoView)

        val persona: persona = intent!!.extras!!.getSerializable("persona") as persona
        nombre.setText(persona.nombre)
        apellido.setText(persona.apellido)
        correo.setText(persona.correo)
    }
}