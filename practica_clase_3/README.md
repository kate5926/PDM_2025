# Actividades en Clase: Listas Dinámicas y CRUD Local con Provider en Flutter.

# Gestión de Usuarios con Flutter (MVVM + Provider)

Este proyecto implementa un sistema completo de gestión de usuarios usando Flutter, Provider y el patrón MVVM. Incluye CRUD, validaciones, filtro dinámico y una interfaz reactiva sin necesidad de `setState()` manual.

---

## Características

- **CRUD completo:** Agregar, editar y eliminar usuarios.  
- **Campos de usuario:** Nombre, género (Masculino/Femenino), estado (activo/inactivo), edad numérica y correo con validación.  
- **Validaciones:** Nombre no vacío, edad mayor a 0, correo con formato válido.  
- **Filtro dinámico:** Opción para mostrar solo usuarios activos.  
- **UI interactiva:** RadioButton para género, Switch para estado activo y listas que se actualizan automáticamente con Provider.  
- **Patrón MVVM:** Separación clara entre Modelo (`User`), ViewModel (`UserViewModel`) y Vistas.  
- **Estado reactivo:** Cambios reflejados en tiempo real sin usar `setState()`.

---

## Requisitos

- **Flutter SDK:** 3.0.0 o superior  
- **Dart:** Incluido con Flutter  
- **Dependencias:**  
  - `provider: ^6.1.5+1` (se instala con `flutter pub get`)
- **Entorno de desarrollo:** Android Studio, VS Code o similar  
- **Plataforma:** Android, iOS y Web  
- **Windows:** Requiere Visual Studio con herramientas de C++ (para desarrollo desktop)

---
##Estructura del sistema

lib/
├── main.dart                    # Punto de entrada de la app, configuración de Provider
├── models/
│   └── user.dart                # Modelo de datos para User
├── viewmodels/
│   └── user_view_model.dart     # Lógica de negocio (CRUD, filtro, ChangeNotifier)
└── views/
    ├── user_list_screen.dart    # Pantalla principal con lista de usuarios
    └── user_form_screen.dart    # Formulario para agregar/editar usuarios
---
## Instalación

1. Clona o descarga el proyecto.  
2. Abre la terminal y navega al directorio del proyecto.  
3. Ejecuta:

   ```bash
   flutter pub get


## Getting Started

This project is a starting point for a Flutter application.

A few resources to get you started if this is your first Flutter project:

- [Lab: Write your first Flutter app](https://docs.flutter.dev/get-started/codelab)
- [Cookbook: Useful Flutter samples](https://docs.flutter.dev/cookbook)

For help getting started with Flutter development, view the
[online documentation](https://docs.flutter.dev/), which offers tutorials,
samples, guidance on mobile development, and a full API reference.
