import 'package:flutter/material.dart';

// Importamos los archivos de las pantallas que crearemos
import 'pantalla_inicio.dart';
import 'pantalla_perfil.dart';
import 'pantalla_hobbies.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Mi App Personal',  // Título de la app (aparece en el dispositivo)
      home: PantallaInicio(),  // Cambia esta línea para probar: PantallaInicio(), PantallaPerfil(), o PantallaHobbies()
    );
  }
}