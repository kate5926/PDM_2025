/* Descripción: Reproductor de música con botones y una imagen interactiva usando Jetpack Compose.
 Permite reproducir, pausar y detener música local, y muestra un mensaje al tocar la imagen.
Autor: Katherine Saico
Fecha creación: 07/09/2025
Fecha última modificación: 10/09/2025 */


// Paquete principal del proyecto
package com.example.musica2

// Imports necesarios
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.musica2.ui.theme.Musica2Theme

/*
MainActivity: Actividad principal del reproductor.
- Hereda de ComponentActivity para usar Jetpack Compose.
- Crea y maneja MediaPlayer para reproducir música local.
- Configura la UI usando Compose: imagen interactiva y botones de control.
*/
class MainActivity : ComponentActivity() {

    // MediaPlayer nullable para poder reinicializar después de stop
    private var mediaPlayer: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()  // Permite que la UI ocupe toda la pantalla, borde a borde
        mediaPlayer = MediaPlayer.create(this, R.raw.musica1)  // Inicializa el MediaPlayer con la música local

        // Define la UI usando Jetpack Compose
        setContent {
            Musica2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MusicPlayerScreen(
                        modifier = Modifier.padding(innerPadding),
                        onImageClick = {
                            // Muestra un Toast al tocar la imagen
                            Toast.makeText(this, "¡Hola! Tocaste al gato ", Toast.LENGTH_SHORT).show()
                        },
                        onPlay = {
                            if (mediaPlayer == null) {
                                mediaPlayer = MediaPlayer.create(this, R.raw.musica1)
                            }
                            mediaPlayer?.start()
                        },
                        onPause = {
                            if (mediaPlayer?.isPlaying == true) {
                                mediaPlayer?.pause()
                            }
                        },
                        onStop = {
                            mediaPlayer?.let {
                                if (it.isPlaying) {
                                    it.stop()
                                    it.release()
                                    mediaPlayer = null
                                }
                            }
                        }
                    )
                }
            }
        }
    }

    // Liberar recursos de MediaPlayer al destruir la actividad
    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.release()
        mediaPlayer = null
    }
}

/*
MusicPlayerScreen: representa la interfaz del reproductor.
- Columna principal que organiza la imagen y botones.
- Image interactiva con evento onClick.
- Botones para reproducir, pausar y detener la música.
*/
@Composable
fun MusicPlayerScreen(
    modifier: Modifier = Modifier,
    onImageClick: () -> Unit,
    onPlay: () -> Unit,
    onPause: () -> Unit,
    onStop: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(text = "Reproductor de Música", modifier = Modifier.fillMaxWidth())

        Image(
            painter = painterResource(id = R.drawable.gato2),
            contentDescription = "Imagen de gato",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .clickable { onImageClick() }  // Acción al tocar la imagen
        )

        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(onClick = onPlay, modifier = Modifier.weight(1f)) { Text("▶ Reproducir") }
            Button(onClick = onPause, modifier = Modifier.weight(1f)) { Text("⏸ Pausar") }
            Button(onClick = onStop, modifier = Modifier.weight(1f)) { Text("⏹ Detener") }
        }
    }
}

/*
Preview
- Permite ver la interfaz en el editor sin ejecutar la app.
*/
@Preview(showBackground = true)
@Composable
fun MusicPlayerScreenPreview() {
    Musica2Theme {
        MusicPlayerScreen(
            onImageClick = {},
            onPlay = {},
            onPause = {},
            onStop = {}
        )
    }
}
