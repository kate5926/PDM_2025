import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import '../viewmodels/user_view_model.dart';
import '../models/user.dart';
import 'user_form_screen.dart';

class UserListScreen extends StatelessWidget {
  const UserListScreen({super.key});

  @override
  Widget build(BuildContext context) {
    // Obtiene el ViewModel usando Provider para escuchar cambios
    final viewModel = context.watch<UserViewModel>();

    return Scaffold(
      appBar: AppBar(
        title: const Text('Lista de Usuarios'),
        actions: [
          // Botón para alternar filtro de usuarios activos
          IconButton(
            icon: Icon(viewModel.mostrarSoloActivos ? Icons.filter_list : Icons.filter_list_off),
            onPressed: () => viewModel.toggleFiltroActivos(),
          ),
        ],
      ),
      // Lista de usuarios usando ListView.builder para mejor rendimiento
      body: ListView.builder(
        itemCount: viewModel.usuariosFiltrados.length,
        itemBuilder: (context, index) {
          final user = viewModel.usuariosFiltrados[index];
          return Card(
            child: ListTile(
              title: Text(user.nombre),
              subtitle: Text('${user.genero} - ${user.activo ? 'Activo' : 'Inactivo'} - Edad: ${user.edat'} - Correo: ${user.correo}'),
              trailing: Row(
                mainAxisSize: MainAxisSize.min,
                children: [
                  // Botón para editar usuario
                  IconButton(
                    icon: const Icon(Icons.edit),
                    onPressed: () async {
                      // Navega a la pantalla de formulario para editar
                      final actualizado = await Navigator.push(
                        context,
                        MaterialPageRoute(
                          builder: (_) => UserFormScreen(
                            usuario: user,
                            indice: index,
                          ),
                        ),
                      );
                      // Si se retornó un usuario actualizado, lo guarda
                      if (actualizado != null && actualizado is User) {
                        viewModel.editarUsuario(index, actualizado);
                      }
                    },
                  ),
                  // Botón para eliminar usuario
                  IconButton(
                    icon: const Icon(Icons.delete, color: Colors.red),
                    onPressed: () => viewModel.eliminarUsuario(index),
                  ),
                ],
              ),
            ),
          );
        },
      ),
      // Botón flotante para agregar nuevo usuario
      floatingActionButton: FloatingActionButton(
        onPressed: () async {
          // Navega a la pantalla de formulario para crear nuevo usuario
          final nuevoUsuario = await Navigator.push(
            context,
            MaterialPageRoute(builder: (_) => const UserFormScreen()),
          );
          // Si se retornó un nuevo usuario, lo agrega a la lista
          if (nuevoUsuario != null && nuevoUsuario is User) {
            viewModel.agregarUsuario(nuevoUsuario);
          }
        },
        child: const Icon(Icons.add),
      ),
    );
  }
}
