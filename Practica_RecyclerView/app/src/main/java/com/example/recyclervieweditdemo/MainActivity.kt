// App para manejar lista de usuarios con RecyclerView
// Hecho por: Katherine Saico
// Empezado: 03/10/2024
// Último cambio: 03/10/2024

package com.tudominio.recyclervieweditdemo

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    // Variables para el RecyclerView y la lista
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: UsuarioAdapter
    private val listaUsuarios = mutableListOf<Usuario>() // Aquí guardamos los usuarios

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Llamamos a los metodos
        inicializarVistas()
        configurarRecyclerView()
        cargarDatosIniciales()
    }

    // Este metodo encuentra las vistas en el layout
    private fun inicializarVistas() {
        recyclerView = findViewById(R.id.recyclerView)
        val btnAgregar = findViewById<Button>(R.id.btnAgregar)

        // Cuando hacen click en el botón, muestra el diálogo para agregar usuario
        btnAgregar.setOnClickListener {
            mostrarDialogoAgregar()
        }
    }

    // Configura el RecyclerView con el adaptador
    private fun configurarRecyclerView() {
        adapter = UsuarioAdapter(listaUsuarios) // Le pasamos la lista de usuarios
        recyclerView.layoutManager = LinearLayoutManager(this) // Forma de mostrar los items
        recyclerView.adapter = adapter // Conectamos el adaptador
    }

    // Agrega algunos usuarios de ejemplo al empezar
    private fun cargarDatosIniciales() {
        listaUsuarios.add(Usuario("Juan Pérez", 25, "juan@email.com"))
        listaUsuarios.add(Usuario("María García", 30, "maria@email.com"))
        listaUsuarios.add(Usuario("Carlos López", 28, "carlos@email.com"))
        adapter.notifyDataSetChanged() // Actualiza la lista
    }

    // Muestra un popup para agregar nuevo usuario
    private fun mostrarDialogoAgregar() {
        // Inflamos el layout del diálogo personalizado
        val dialogView = LayoutInflater.from(this)
            .inflate(R.layout.dialog_add_usuario, null)

        // Obtenemos los EditText del diálogo
        val editNombre = dialogView.findViewById<EditText>(R.id.editNombre)
        val editEdad = dialogView.findViewById<EditText>(R.id.editEdad)
        val editCorreo = dialogView.findViewById<EditText>(R.id.editCorreo)

        // Creamos y mostramos el AlertDialog
        AlertDialog.Builder(this)
            .setTitle("Agregar usuario")
            .setView(dialogView)
            .setPositiveButton("Agregar") { _, _ ->
                // Esto se ejecuta cuando le dan a Agregar
                val nombre = editNombre.text.toString().trim()
                val edad = editEdad.text.toString().toIntOrNull() ?: 0
                val correo = editCorreo.text.toString().trim()

                // Validamos que los campos no estén vacíos
                if (nombre.isNotEmpty() && edad > 0 && correo.isNotEmpty()) {
                    val nuevoUsuario = Usuario(nombre, edad, correo)
                    adapter.agregarUsuario(nuevoUsuario) // Agregamos a la lista
                    Toast.makeText(this, "Usuario agregado", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Completa todos los campos", Toast.LENGTH_SHORT).show()
                }
            }
            .setNegativeButton("Cancelar", null) // No hace nada, solo cierra
            .show()
    }
}