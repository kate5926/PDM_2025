package com.example.ciclodevidaapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private var contador = 0
    private lateinit var lblContador: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lblContador = findViewById(R.id.textViewContador)
        val botonSumar = findViewById<Button>(R.id.btnAumentar)

        // Acción del botón: incrementar el contador
        botonSumar.setOnClickListener {
            contador += 1
            lblContador.text = "Valor actual: $contador"
        }

        Log.i("CICLOVIDA", "onCreate ejecutado")
        Toast.makeText(this, "Se creó la Activity", Toast.LENGTH_SHORT).show()
    }

    override fun onStart() {
        super.onStart()
        Log.i("CICLOVIDA", "onStart ejecutado")
        Toast.makeText(this, "Pantalla visible", Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        Log.i("CICLOVIDA", "onResume ejecutado")
        Toast.makeText(this, "App lista para usar", Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
        Log.i("CICLOVIDA", "onPause ejecutado")
        Toast.makeText(this, "App en pausa", Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()
        Log.i("CICLOVIDA", "onStop ejecutado")
        Toast.makeText(this, "App detenida", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("CICLOVIDA", "onDestroy ejecutado")
        Toast.makeText(this, "Activity destruida", Toast.LENGTH_SHORT).show()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        // Guardar el contador en caso de que se destruya la Activity
        outState.putInt("KEY_CONTADOR", contador)
        Log.i("CICLOVIDA", "Guardando contador = $contador")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        // Recuperar el contador guardado
        contador = savedInstanceState.getInt("KEY_CONTADOR")
        lblContador.text = "Valor actual: $contador"
        Log.i("CICLOVIDA", "Recuperando contador = $contador")
    }
}
