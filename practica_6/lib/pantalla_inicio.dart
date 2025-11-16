import 'package:flutter/material.dart';

class PantallaInicio extends StatelessWidget {
  const PantallaInicio({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      // Scaffold es el contenedor principal de la pantalla, incluye AppBar y body
      appBar: AppBar(
        title: const Text('Bienvenido'),  // Título del AppBar
        backgroundColor: Colors.blue,
      ),
      body: Center(  // Centra
        child: Padding(  // Padding agrega espacio alrededor del contenido
          padding: const EdgeInsets.all(20.0),
          child: Column(  // Column organiza los widgets en una columna vertical
            mainAxisAlignment: MainAxisAlignment.center,
            children: [

              const Text(
                '¡Hola! Bienvenido a mi app personal.',
                style: TextStyle(fontSize: 24, fontWeight: FontWeight.bold),
                textAlign: TextAlign.center,  // Centra el texto
              ),
              const SizedBox(height: 20),
              // Botón (no funcional )
              ElevatedButton(
                onPressed: null,
                child: const Text('Ver mi perfil'),  // Texto del botón
              ),
            ],
          ),
        ),
      ),
    );
  }
}