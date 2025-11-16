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

La estructura del sistema se organiza dentro de la carpeta lib, donde main.dart actúa como punto de entrada de la aplicación y configura Provider; la carpeta models contiene user.dart, que define el modelo de datos del usuario (nombre, género, estado activo, edad y correo); la carpeta viewmodels incluye user_view_model.dart, encargado de la lógica de negocio como el CRUD, el filtro de usuarios activos y las notificaciones mediante ChangeNotifier; finalmente, la carpeta views contiene user_list_screen.dart, que muestra la lista de usuarios y las acciones disponibles, y user_form_screen.dart, que permite agregar o editar usuarios.

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
