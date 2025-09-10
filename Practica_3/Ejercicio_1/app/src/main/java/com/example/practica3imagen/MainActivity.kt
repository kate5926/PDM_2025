/*
Descripción: Actividad que muestra una imagen y al hacer clic despliega un Toast.
Autor: [Tu Nombre]
Fecha creación: 31/08/2025
Fecha última modificación: 31/08/2025
*/

package com.example.practica3imagen

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.practica3imagen.ui.theme.Practica3ImagenTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Practica3ImagenTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ImagenConToast()
                }
            }
        }
    }
}

@Composable
fun ImagenConToast() {
    val context = LocalContext.current

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.gato), // imagen gato.png
            contentDescription = "Imagen de un gato",
            modifier = Modifier
                .size(250.dp)
                .clickable {
                    Toast.makeText(context, "¡Hiciste clic en el gato!", Toast.LENGTH_SHORT).show()
                }
        )
    }
}
