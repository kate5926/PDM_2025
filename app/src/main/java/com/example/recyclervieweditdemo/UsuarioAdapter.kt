// Adaptador para el RecyclerView - Maneja la lista de usuarios
// Hecho por: Katherine Saico
// Fecha: 20/01/2024

package com.tudominio.recyclervieweditdemo

import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UsuarioAdapter(
    private val usuarios: MutableList<Usuario>  // Lista de usuarios que vamos a mostrar
) : RecyclerView.Adapter<UsuarioAdapter.UsuarioViewHolder>() {

    // Esta clase representa cada item (fila) en el RecyclerView
    inner class UsuarioViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Enlazamos los TextView del layout item_usuario.xml
        private val tvNombre: TextView = itemView.findViewById(R.id.tvNombre)
        private val tvEdad: TextView = itemView.findViewById(R.id.tvEdad)
        private val tvCorreo: TextView = itemView.findViewById(R.id.tvCorreo)


        fun bind(usuario: Usuario) {
            tvNombre.text = usuario.nombre
            tvEdad.text = "Edad: ${usuario.edad}"
            tvCorreo.text = usuario.correo

            // Cuando hacemos LONG CLICK en un usuario, mostramos el menú de opciones
            itemView.setOnLongClickListener {
                val pos = bindingAdapterPosition
                if (pos != RecyclerView.NO_POSITION) {
                    mostrarMenuOpciones(pos, usuario)
                }
                true  // Devuelve true para indicar que manejamos el evento
            }
        }

        // Muestra el menú con opciones Editar/Eliminar
        private fun mostrarMenuOpciones(pos: Int, usuario: Usuario) {
            AlertDialog.Builder(itemView.context)
                .setTitle("Acción")
                .setItems(arrayOf("Editar", "Eliminar")) { _, which ->
                    when (which) {
                        0 -> mostrarDialogoEditar(pos, usuario)  // Editar
                        1 -> eliminarUsuario(pos)                // Eliminar
                    }
                }
                .show()
        }

        // Muestra el diálogo para editar un usuario
        private fun mostrarDialogoEditar(pos: Int, usuario: Usuario) {
            // Inflamos el layout del diálogo de edición
            val dialogView = LayoutInflater.from(itemView.context)
                .inflate(R.layout.dialog_edit_usuario, null)

            // Obtenemos los EditText del diálogo
            val editNombre = dialogView.findViewById<EditText>(R.id.editNombre)
            val editEdad = dialogView.findViewById<EditText>(R.id.editEdad)
            val editCorreo = dialogView.findViewById<EditText>(R.id.editCorreo)

            // Ponemos los valores actuales del usuario en los campos
            editNombre.setText(usuario.nombre)
            editEdad.setText(usuario.edad.toString())
            editCorreo.setText(usuario.correo)

            // Creamos el diálogo de edición
            AlertDialog.Builder(itemView.context)
                .setTitle("Editar usuario")
                .setView(dialogView)
                .setPositiveButton("Guardar") { _, _ ->
                    // Cuando le dan a Guardar, actualizamos el usuario
                    val nuevoNombre = editNombre.text.toString().trim()
                    val nuevaEdad = editEdad.text.toString().toIntOrNull() ?: usuario.edad
                    val nuevoCorreo = editCorreo.text.toString().trim()

                    // Validamos que los campos no estén vacíos
                    if (nuevoNombre.isNotEmpty() && nuevoCorreo.isNotEmpty()) {
                        // Actualizamos los datos del usuario
                        usuario.nombre = nuevoNombre
                        usuario.edad = nuevaEdad
                        usuario.correo = nuevoCorreo
                        notifyItemChanged(pos)  // Actualizamos solo este item en la lista
                    }
                }
                .setNegativeButton("Cancelar", null)  // No hace nada, solo cierra
                .show()
        }

        // Metodo para eliminar un usuario con confirmación
        private fun eliminarUsuario(pos: Int) {
            AlertDialog.Builder(itemView.context)
                .setTitle("Confirmar eliminación")
                .setMessage("¿Estás seguro de eliminar este usuario?")
                .setPositiveButton("Sí") { _, _ ->
                    // Eliminamos el usuario de la lista
                    usuarios.removeAt(pos)
                    notifyItemRemoved(pos)  // Notificamos que quitamos un item
                }
                .setNegativeButton("No", null)  // No hace nada
                .show()
        }
    }

    // Crea nuevos ViewHolders cuando el RecyclerView los necesita
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsuarioViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_usuario, parent, false)
        return UsuarioViewHolder(view)
    }

    // Pone los datos en el ViewHolder cuando se muestra en pantalla
    override fun onBindViewHolder(holder: UsuarioViewHolder, position: Int) {
        holder.bind(usuarios[position])
    }

    // Dice cuantos items hay en la lista
    override fun getItemCount(): Int = usuarios.size

    // Metodo para agregar un nuevo usuario desde MainActivity
    fun agregarUsuario(usuario: Usuario) {
        usuarios.add(usuario)
        notifyItemInserted(usuarios.size - 1)  // Notificamos que agregamos un item al final
    }
}