/**
 * OpcionesActivity.kt
 * Descripción: Muestra la nota recibida desde EditorActivity y permite compartirla o volver a editarla.
 * Autor: Kat
 * Fecha de creación: 27/09/2025
 * Última modificación: 28/09/2025
 */

package com.example.editornota_b

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class OpcionesActivity : AppCompatActivity() {

    private lateinit var tvNota: TextView
    private lateinit var btnCompartirCorreo: Button
    private lateinit var btnEditarNuevo: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_opciones2)

        // Referencias UI
        tvNota = findViewById(R.id.tvNota)
        btnCompartirCorreo = findViewById(R.id.btnCompartirCorreo)
        btnEditarNuevo = findViewById(R.id.btnEditarNuevo)

        // Recuperar la nota recibida
        val notaRecibida = intent.getStringExtra("nota") ?: "Sin nota"
        tvNota.text = notaRecibida

        // Botón compartir por correo
        btnCompartirCorreo.setOnClickListener {
            Toast.makeText(this, "Compartido por correo", Toast.LENGTH_SHORT).show()
        }

        // Botón volver a editar
        btnEditarNuevo.setOnClickListener {
            val resultIntent = Intent().apply {
                putExtra("nota_editada", notaRecibida)
            }
            setResult(Activity.RESULT_OK, resultIntent)
            finish() // Cierra esta actividad y regresa a EditorActivity
        }
    }
}
