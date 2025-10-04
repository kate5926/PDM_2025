
// Descripción corta del problema: Fragmento inicial que permite iniciar un nuevo pedido de comida navegando al fragmento de selección de comida.
// Autor: Katherine
// Fecha creación: 2023-10-01
// Fecha última modificación: 2023-10-02

package com.example.practica_5.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.practica_5.R

class InicioFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_inicio, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnNuevoPedido: Button = view.findViewById(R.id.btnNuevoPedido)
        btnNuevoPedido.setOnClickListener {
            findNavController().navigate(R.id.action_inicio_to_seleccionComida)
        }
    }
}