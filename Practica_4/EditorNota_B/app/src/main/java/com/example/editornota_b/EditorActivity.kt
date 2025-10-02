/**
 * EditorActivity.kt
 * Descripción: Permite al usuario escribir una nota y enviarla a OpcionesActivity.
 * Autor: Katherine Saico
 * Fecha de creación: 28/09/2025
 * Última modificación: 30/09/2025
 */

package com.example.editornota_b

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

// Campo de texto donde el usuario escribe su nota
class EditorActivity : AppCompatActivity() {

    private lateinit var etNota: EditText
    private lateinit var btnCompartir: Button  // Botón que permite compartir la nota


    private val opcionesLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            // Recuperar la nota editada que viene de OpcionesActivity
            val notaEditada = result.data?.getStringExtra("nota_editada")
            etNota.setText(notaEditada) // Restaura la nota si vuelve a editar
            Toast.makeText(this, "Nota restaurada para edición", Toast.LENGTH_SHORT).show()
        }
    }
    /**
     * Método principal que se ejecuta al iniciar la actividad.
     * Aquí se asocian los elementos de la interfaz y se configuran las acciones.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editor)

        etNota = findViewById(R.id.etNota)
        btnCompartir = findViewById(R.id.btnCompartir)

        // Restaurar nota en caso de rotación
        savedInstanceState?.getString("nota_guardada")?.let {
            etNota.setText(it)
        }
        // Acción del botón Compartir
        btnCompartir.setOnClickListener {
            val nota = etNota.text.toString()
            if (nota.isNotEmpty()) {
                val intent = Intent(this, OpcionesActivity::class.java)
                intent.putExtra("nota", nota)
                opcionesLauncher.launch(intent)
            } else {
                Toast.makeText(this, "Escribe una nota antes de compartir", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // Guardar nota si se rota la pantalla
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("nota_guardada", etNota.text.toString())
    }
}
