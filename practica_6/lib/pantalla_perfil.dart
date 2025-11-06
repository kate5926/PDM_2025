import 'package:flutter/material.dart';

class PantallaPerfil extends StatelessWidget {
  const PantallaPerfil({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Mi Perfil'),  // Título
        backgroundColor: Colors.green,
      ),
      body: Padding(
        padding: const EdgeInsets.all(20.0),  // Padding general
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.center,  // Centra horizontalmente
          children: [
            // Imagen
            Image.network(
              'https://www.google.com/url?sa=i&url=https%3A%2F%2Fdepositphotos.com%2Fes%2Fvector%2Fyoung-woman-avatar-cartoon-character-profile-picture-273554722.html&psig=AOvVaw2hZVyDDNYrhkbdsIpMbJwB&ust=1762508906232000&source=images&cd=vfe&opi=89978449&ved=0CBIQjRxqFwoTCNDMiNCf3ZADFQAAAAAdAAAAABAL',
              height: 150,  // Altura fija
              width: 150,   // Ancho fijo
              fit: BoxFit.cover,  // Ajusta la imagen para que llene el espacio
            ),
            const SizedBox(height: 20),  // Espacio

            const Text(
              'Mi Nombre: Katherine Saico',
              style: TextStyle(fontSize: 22, fontWeight: FontWeight.bold),
            ),
            const SizedBox(height: 10),
            const Text(
              'Soy estudiante de Ingeniería en sotware. ',
              style: TextStyle(fontSize: 16),
              textAlign: TextAlign.center,
            ),
            const SizedBox(height: 20),
            // Información de contacto en filas con íconos
            Row(  // Row organiza en horizontal
              mainAxisAlignment: MainAxisAlignment.center,  // Centra la fila
              children: [
                const Icon(Icons.email, color: Colors.blue),
                const SizedBox(width: 10),  // Espacio
                const Text('kathy@email.com')
              ],
            ),
            const SizedBox(height: 10),
            Row(
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                const Icon(Icons.phone, color: Colors.green),
                const SizedBox(width: 10),
                const Text('+53 945 789 563'),
              ],
            ),
          ],
        ),
      ),
    );
  }
}