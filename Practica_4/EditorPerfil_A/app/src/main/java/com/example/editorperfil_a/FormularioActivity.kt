/**
 * Actividad principal con formulario para llenar perfil de usuario.
 * Autor:Katherine saico
 * Fecha creación: 25/09/25
 * Fecha última modificación: 29/09/25
 */

package com.example.editorperfil_a

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity


class FormularioActivity : AppCompatActivity() {

    private lateinit var etNombre: EditText
    private lateinit var etEdad: EditText
    private lateinit var etCiudad: EditText
    private lateinit var etCorreo: EditText
    private lateinit var btnContinuar: Button

    // Clave para guardar estado
    companion object {
        private const val KEY_NOMBRE = "key_nombre"
        private const val KEY_EDAD = "key_edad"
        private const val KEY_CIUDAD = "key_ciudad"
        private const val KEY_CORREO = "key_correo"
    }

    // Registrar el resultado de ResumenActivity
    private val resumenLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode  == RESULT_OK) {
            val mensaje = result.data?.getStringExtra("mensaje")
            if (mensaje != null) {
                Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show()
            }
        } else if (result.resultCode == RESULT_CANCELED) {
            Toast.makeText(this, "Edición cancelada", Toast.LENGTH_SHORT).show()
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario)

        etNombre = findViewById(R.id.etNombre)
        etEdad = findViewById(R.id.etEdad)
        etCiudad = findViewById(R.id.etCiudad)
        etCorreo = findViewById(R.id.etCorreo)
        btnContinuar = findViewById(R.id.btnContinuar)

        // Restaurar estado si existe
        if (savedInstanceState != null) {
            etNombre.setText(savedInstanceState.getString(KEY_NOMBRE, ""))
            etEdad.setText(savedInstanceState.getString(KEY_EDAD, ""))
            etCiudad.setText(savedInstanceState.getString(KEY_CIUDAD, ""))
            etCorreo.setText(savedInstanceState.getString(KEY_CORREO, ""))
        }

        btnContinuar.setOnClickListener {
            val nombre = etNombre.text.toString().trim()
            val edad = etEdad.text.toString().trim()
            val ciudad = etCiudad.text.toString().trim()
            val correo = etCorreo.text.toString().trim()

            // Validar campos (opcional)
            if (nombre.isEmpty() || edad.isEmpty() || ciudad.isEmpty() || correo.isEmpty()) {
                Toast.makeText(this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val usuario = Usuario(nombre, edad, ciudad, correo)
            val intent = Intent(this, ResumenActivity::class.java)
            intent.putExtra("usuario", usuario)
            resumenLauncher.launch(intent)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(KEY_NOMBRE, etNombre.text.toString())
        outState.putString(KEY_EDAD, etEdad.text.toString())
        outState.putString(KEY_CIUDAD, etCiudad.text.toString())
        outState.putString(KEY_CORREO, etCorreo.text.toString())
    }
}