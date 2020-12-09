package com.example.basededatos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var nombre: EditText
    private lateinit var apellido: EditText
    private lateinit var correo: EditText
    private lateinit var boton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nombre = findViewById(R.id.txtNombre)
        apellido = findViewById(R.id.txtApellido)
        correo = findViewById(R.id.txtCorreo)
        boton = findViewById(R.id.button)
        boton.setOnClickListener {
            if(registra()){
                Toast.makeText(applicationContext,
                "Agregado correctamente",
                Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun registra(): Boolean {
        return daoPersona(applicationContext).insertar(
            persona(
                nombre.text.toString(),
                apellido.text.toString(),
                correo.text.toString()
            )
        )
    }
}