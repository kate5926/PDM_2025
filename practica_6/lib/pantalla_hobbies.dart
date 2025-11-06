import 'package:flutter/material.dart';

class PantallaHobbies extends StatelessWidget {
  const PantallaHobbies({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Mis Hobbies'),  // Título
        backgroundColor: Colors.orange,
      ),
      body: Padding(
        padding: const EdgeInsets.all(20.0),
        child: Column(  // Organiza en columna
          children: [
            // Título de la sección
            const Text(
              'Mis intereses y hobbies:',  // Texto introductorio
              style: TextStyle(fontSize: 20, fontWeight: FontWeight.bold),
            ),
            const SizedBox(height: 20),
            // Lista de hobbies en filas
            Row(  // Primer hobby: Leer
              children: [
                const Icon(Icons.book, size: 40, color: Colors.blue),  // Ícono
                const SizedBox(width: 10),
                const Expanded(  // Expanded hace que el texto ocupe el espacio restante
                  child: Text(
                    'Leer libros de ciencia ficción y fantasía.',
                    style: TextStyle(fontSize: 16),
                  ),
                ),
              ],
            ),
            const SizedBox(height: 15),
            Row(  // Segundo hobby: Videojuegos
              children: [
                const Icon(Icons.videogame_asset, size: 40, color: Colors.green),
                const SizedBox(width: 10),
                const Expanded(
                  child: Text(
                    'Jugar videojuegos  con amigos.',
                    style: TextStyle(fontSize: 16),
                  ),
                ),
              ],
            ),
            const SizedBox(height: 15),
            Row(  // Tercer hobby: Música
              children: [
                const Icon(Icons.music_note, size: 40, color: Colors.red),
                const SizedBox(width: 10),
                const Expanded(
                  child: Text(
                    'Escuchar música  y tocar la guitarra.',
                    style: TextStyle(fontSize: 16),
                  ),
                ),
              ],
            ),
            //imagen
            const SizedBox(height: 20),
            Image.network(
              'https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.freepik.es%2Fvector-premium%2Fchica-banda-tocando-guitarra-bombo-cute-dibujos-animados_33529698.htm&psig=AOvVaw1y-ReEFtOynDVtQnN37TNi&ust=1762509411248000&source=images&cd=vfe&opi=89978449&ved=0CBUQjRxqFwoTCJi70bGh3ZADFQAAAAAdAAAAABAE',
              height: 100,
              fit: BoxFit.cover,
            ),
          ],
        ),
      ),
    );
  }
}