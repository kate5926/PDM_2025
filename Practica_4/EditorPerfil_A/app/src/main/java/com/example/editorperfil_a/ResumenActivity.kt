/**
 * Actividad que muestra resumen del perfil y permite confirmar o editar.
 * Autor: Katherine saico
 * Fecha creación: 25/09/25
 * Fecha última modificación: 29/09/25
 */

package com.example.editorperfil_a

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResumenActivity : AppCompatActivity() {

    private lateinit var tvResumen: TextView
    private lateinit var btnConfirmar: Button
    private lateinit var btnVolverEditar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resumen)
        tvResumen = findViewById(R.id.tvResumen)
        btnConfirmar = findViewById(R.id.btnConfirmar)
        btnVolverEditar = findViewById(R.id.btnVolverEditar)

        val usuario = intent.getSerializableExtra("usuario") as? Usuario

        if (usuario != null) {
            val resumenTexto = """
                Nombre: ${usuario.nombre}
                Edad: ${usuario.edad}
                Ciudad: ${usuario.ciudad}
                Correo: ${usuario.correo}
            """.trimIndent()
            tvResumen.text = resumenTexto
        } else {
            tvResumen.text = "No hay datos para mostrar."
        }

        btnConfirmar.setOnClickListener {
            val intent = Intent()
            intent.putExtra("mensaje", "Perfil guardado correctamente")
            setResult(Activity.RESULT_OK, intent)
            finish()
        }

        btnVolverEditar.setOnClickListener {
            setResult(Activity.RESULT_CANCELED)
            finish()
        }
    }
}