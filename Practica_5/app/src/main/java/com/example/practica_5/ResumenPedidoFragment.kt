// ResumenPedidoFragment.kt
package com.example.practica_5.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import com.example.practica_5.R

class ResumenPedidoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_resumen_pedido, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tvResumen: TextView = view.findViewById(R.id.tvResumen)
        val btnConfirmar: Button = view.findViewById(R.id.btnConfirmar)
        val btnEditar: Button = view.findViewById(R.id.btnEditar)

        // Recupera argumentos
        val args = arguments
        val comida = args?.getString("comida") ?: "No hay comida"
        val extrasList = args?.getStringArrayList("extras") ?: arrayListOf()
        val extrasTexto = if (extrasList.isNotEmpty()) extrasList.joinToString(", ") else "Sin extras"

        tvResumen.text = "Comida: $comida\nExtras: $extrasTexto"

        btnConfirmar.setOnClickListener {
            Toast.makeText(context, "Pedido confirmado: $comida con $extrasTexto", Toast.LENGTH_LONG).show()
            // Vuelve al inicio
            findNavController().navigate(R.id.action_resumenPedido_to_inicio)
        }

        btnEditar.setOnClickListener {
            // Prepara bundle con datos actuales para pasar de regreso
            val bundleResultado = Bundle()
            bundleResultado.putString("comida", comida)
            bundleResultado.putStringArrayList("extras", extrasList)

            // Usa setFragmentResult para enviar datos al fragmento anterior (SeleccionComidaFragment)
            setFragmentResult("datosPedido", bundleResultado)

            // Vuelve al fragmento de selección de comida usando popBackStack
            findNavController().popBackStack(R.id.seleccionComida, false)
        }
    }
}