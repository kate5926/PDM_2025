// MainActivity.kt
// Descripción corta del problema: Activity principal que configura el NavHostFragment para la navegación entre fragments del configurador de pedidos.
// Autor: katherine saico
// Fecha creación: 2023-10-01
// Fecha última modificación: 2023-10-02

package com.example.practica_5

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.example.practica_5.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Configura el NavHost para navegación
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

    }

    // onSupportNavigateUp() – el botón Atrás del sistema - popBackStack automáticamente
}