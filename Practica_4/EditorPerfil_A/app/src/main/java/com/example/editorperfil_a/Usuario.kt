/**
 * Data class para representar un usuario.
 * Autor: katherine
 * * Fecha creación: 25/09/25
 *  * Fecha última modificación: 29/09/25
 *  */

package com.example.editorperfil_a
import java.io.Serializable

data class Usuario(
    val nombre: String,
    val edad: String,
    val ciudad: String,
    val correo: String
) : Serializable
