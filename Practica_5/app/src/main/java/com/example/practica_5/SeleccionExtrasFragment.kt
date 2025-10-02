// SeleccionExtrasFragment.kt
// Descripción corta del problema: Fragmento para seleccionar extras del pedido y agregar al Bundle para pasar al resumen.
// Autor: Katherine
// Fecha creación: 2023-10-01
// Fecha última modificación: 2023-10-02


package com.example.practica_5.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.practica_5.R

class SeleccionExtrasFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_seleccion_extras, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val cbBebida: CheckBox = view.findViewById(R.id.cbBebida)
        val cbPapas: CheckBox = view.findViewById(R.id.cbPapas)
        val cbPostre: CheckBox = view.findViewById(R.id.cbPostre)
        val btnSiguiente: Button = view.findViewById(R.id.btnSiguienteExtras)

        // Recupera el bundle de argumentos del fragmento anterior
        val args = arguments
        val tipoComida = args?.getString("comida") ?: "No seleccionada"
        val extrasPrevios = args?.getStringArrayList("extras") ?: arrayListOf()

        // Si hay extras previos, marcarlos
        if (extrasPrevios.contains("bebida")) cbBebida.isChecked = true
        if (extrasPrevios.contains("papas")) cbPapas.isChecked = true
        if (extrasPrevios.contains("postre")) cbPostre.isChecked = true

        btnSiguiente.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("comida", tipoComida)

            val extras = arrayListOf<String>()
            if (cbBebida.isChecked) extras.add("bebida")
            if (cbPapas.isChecked) extras.add("papas")
            if (cbPostre.isChecked) extras.add("postre")

            bundle.putStringArrayList("extras", extras)

            // Navega al resumen
            findNavController().navigate(R.id.action_seleccionExtras_to_resumenPedido, bundle)
        }
    }
}