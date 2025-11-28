# Práctica de Clase: Navegación con BottomNavigationBar en Flutter

## Descripción

Este proyecto es una aplicación Flutter que demuestra el uso de `BottomNavigationBar` para la navegación entre diferentes pantallas. La aplicación también incluye una funcionalidad simple para la gestión de usuarios, mostrando una lista de usuarios y permitiendo la edición del nombre del perfil.

## Objetivo Académico

-   Implementar y entender el funcionamiento de `BottomNavigationBar` en Flutter.
-   Gestionar el estado de la navegación entre diferentes pantallas.
-   Pasar datos entre pantallas (en este caso, el nombre del usuario).
-   Utilizar `StatefulWidget` para gestionar el estado local de una pantalla.

## Funcionalidades Implementadas

-   **Navegación por Pestañas:** La aplicación utiliza un `BottomNavigationBar` con cuatro pestañas: "Inicio", "Usuarios", "Configuración" y "Perfil".
-   **Pantalla de Usuarios:** Muestra una lista de usuarios (integrado con el `UserViewModel` y `UserListScreen`).
-   **Pantalla de Perfil:** Muestra el nombre del usuario actual y un botón para editarlo.
-   **Edición de Perfil:** Al presionar el botón de editar, se abre una nueva pantalla que permite al usuario cambiar su nombre. El nuevo nombre se pasa de vuelta a la pantalla de perfil y se actualiza.

## Estructura del Proyecto

-   `main.dart`: El punto de entrada de la aplicación. Contiene la implementación del `BottomNavigationBar` y la lógica de navegación.
-   `viewmodels/user_view_model.dart`: El `ViewModel` para la gestión de usuarios.
-   `views/user_list_screen.dart`: La pantalla que muestra la lista de usuarios.
-   `models/user.dart`: El modelo de datos para un usuario.
