import 'package:flutter/material.dart';
import '../models/user.dart';

class UserViewModel extends ChangeNotifier {
  final List<User> _usuarios = [];

  List<User> get usuarios => _usuarios;

  // Propiedad para filtro de usuarios activos
  bool _mostrarSoloActivos = false;
  bool get mostrarSoloActivos => _mostrarSoloActivos;

  // Lista filtrada
  List<User> get usuariosFiltrados {
    if (_mostrarSoloActivos) {
      return _usuarios.where((user) => user.activo).toList();
    }
    return _usuarios;
  }

  void agregarUsuario(User usuario) {
    _usuarios.add(usuario);
    notifyListeners();
  }

  void editarUsuario(int index, User usuario) {
    _usuarios[index] = usuario;
    notifyListeners();
  }

  void eliminarUsuario(int index) {
    _usuarios.removeAt(index);
    notifyListeners();
  }

  // Método para alternar filtro
  void toggleFiltroActivos() {
    _mostrarSoloActivos = !_mostrarSoloActivos;
    notifyListeners();
  }
}