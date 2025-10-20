package com.example.examen_parcial

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class WelcomeFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_welcome, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<View>(R.id.btn_start).setOnClickListener {
            findNavController().navigate(R.id.action_welcome_to_game)
        }

        showInstructions()
    }
 //Alertdialog
    private fun showInstructions() {
        AlertDialog.Builder(requireContext())
            .setTitle("Instrucciones del Juego")
            .setMessage("Presiona el botón que coincida con el color del cuadro. Tienes 30 segundos.")
            .setPositiveButton("Entendido") { dialog, _ -> dialog.dismiss() }
            .show()
    }
}