import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import 'viewmodels/user_view_model.dart';
import 'views/user_list_screen.dart';

void main() {
  runApp(
    ChangeNotifierProvider(
      create: (_) => UserViewModel(),
      child: const MyApp(),
    ),
  );
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'BottomNavigationBar con Usuarios',
      theme: ThemeData(primarySwatch: Colors.indigo),
      home: const MyHomePage(),
    );
  }
}

class MyHomePage extends StatefulWidget {
  const MyHomePage({super.key});

  @override
  State<MyHomePage> createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  int _selectedIndex = 0;
  String _nombreUsuario = 'Usuario Anónimo';

  void _onItemTapped(int index) {
    setState(() {
      _selectedIndex = index;
    });
  }

  @override
  Widget build(BuildContext context) {
    final List<Widget> pages = [
      // Inicio
      const Center(child: Text('Inicio', style: TextStyle(fontSize: 24))),
      // Usuarios (integrado con la app anterior)
      const UserListScreen(),
      // Configuración
      const Center(child: Text('Configuración', style: TextStyle(fontSize: 24))),
      // Perfil (actividad extra)
      Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Text('Perfil de: $_nombreUsuario', style: const TextStyle(fontSize: 24)),
            const SizedBox(height: 20),
            ElevatedButton(
              onPressed: () async {
                final nombre = await Navigator.push(
                  context,
                  MaterialPageRoute(builder: (context) => const EditarPerfilScreen()),
                );
                if (nombre != null && nombre.isNotEmpty) {
                  setState(() {
                    _nombreUsuario = nombre;
                  });
                }
              },
              child: const Text('Editar perfil'),
            ),
          ],
        ),
      ),
    ];

    return Scaffold(
      appBar: AppBar(title: const Text('Ejemplo BottomNavigationBar')),
      body: pages[_selectedIndex],
      bottomNavigationBar: BottomNavigationBar(
        currentIndex: _selectedIndex,
        onTap: _onItemTapped,
        items: const [
          BottomNavigationBarItem(icon: Icon(Icons.home), label: 'Inicio'),
          BottomNavigationBarItem(icon: Icon(Icons.people), label: 'Usuarios'),
          BottomNavigationBarItem(icon: Icon(Icons.settings), label: 'Config'),
          BottomNavigationBarItem(icon: Icon(Icons.person), label: 'Perfil'),
        ],
      ),
    );
  }
}

// Pantalla Editar Perfil (actividad extra)
class EditarPerfilScreen extends StatefulWidget {
  const EditarPerfilScreen({super.key});

  @override
  State<EditarPerfilScreen> createState() => _EditarPerfilScreenState();
}

class _EditarPerfilScreenState extends State<EditarPerfilScreen> {
  final TextEditingController _controller = TextEditingController();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text('Editar perfil')),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          children: [
            TextField(
              controller: _controller,
              decoration: const InputDecoration(labelText: 'Nombre'),
            ),
            const SizedBox(height: 20),
            ElevatedButton(
              onPressed: () {
                Navigator.pop(context, _controller.text);
              },
              child: const Text('Guardar'),
            ),
          ],
        ),
      ),
    );
  }
}