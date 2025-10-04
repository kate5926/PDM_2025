
// Descripción corta del problema: Fragmento para seleccionar el tipo de comida principal y pasar los datos al siguiente fragmento usando Bundle.
// Autor:Katherine
// Fecha creación: 2023-10-01
// Fecha última modificación: 2023-10-02

package com.example.practica_5.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import com.example.practica_5.R

class SeleccionComidaFragment : Fragment() {

    private var tipoComidaSeleccionada: String? = null
    private var extrasSeleccionados: MutableList<String> = mutableListOf() // Para recuperar si se edita

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_seleccion_comida, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val radioGroupComida: RadioGroup = view.findViewById(R.id.radioGroupComida)
        val btnSiguiente: Button = view.findViewById(R.id.btnSiguienteComida)

        // Listener para recuperar datos si se edita el pedido
        setFragmentResultListener("datosPedido") { _, bundle ->
            tipoComidaSeleccionada = bundle.getString("comida")
            val extras = bundle.getStringArrayList("extras")
            if (extras != null) {
                extrasSeleccionados = extras
            }
            // Marcar la selección si hay datos previos
            if (tipoComidaSeleccionada != null) {
                when (tipoComidaSeleccionada) {
                    "pizza" -> radioGroupComida.check(R.id.radioPizza)
                    "hamburguesa" -> radioGroupComida.check(R.id.radioHamburguesa)
                    "ensalada" -> radioGroupComida.check(R.id.radioEnsalada)
                }
            }
        }

        radioGroupComida.setOnCheckedChangeListener { _, checkedId ->
            val radioButton = view.findViewById<RadioButton>(checkedId)
            tipoComidaSeleccionada = radioButton.text.toString().lowercase()
        }

        btnSiguiente.setOnClickListener {
            if (tipoComidaSeleccionada != null) {
                val bundle = Bundle()
                bundle.putString("comida", tipoComidaSeleccionada)
                // Si hay extras previos, los pasamos también
                if (extrasSeleccionados.isNotEmpty()) {
                    bundle.putStringArrayList("extras", ArrayList(extrasSeleccionados))
                }
                // Navega al fragmento de extras
                findNavController().navigate(R.id.action_seleccionComida_to_seleccionExtras, bundle)
            } else {
                // Mensaje simple si no selecciona nada
                Toast.makeText(context, "Selecciona una comida", Toast.LENGTH_SHORT).show()
            }
        }
    }
}