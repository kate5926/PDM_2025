# Práctica: Pantalla de Login con Validación en Flutter

## Descripción

Este proyecto es una aplicación Flutter que implementa una pantalla de inicio de sesión con validación de campos para correo electrónico y contraseña. Una vez que el usuario ingresa credenciales válidas, es redirigido a una pantalla de lista de usuarios.

## Objetivo Académico

-   Implementar un formulario de inicio de sesión con `TextFormField`.
-   Utilizar `GlobalKey<FormState>` para gestionar y validar el estado del formulario.
-   Aplicar reglas de validación personalizadas para correo electrónico y contraseña.
-   Navegar a una nueva pantalla después de una validación exitosa.

## Funcionalidades Implementadas

-   **Formulario de Inicio de Sesión:** Un formulario con campos para correo electrónico y contraseña.
-   **Validación de Correo Electrónico:**
    -   El campo no puede estar vacío.
    -   Debe contener el carácter `@`.
-   **Validación de Contraseña:**
    -   El campo no puede estar vacío.
    -   Debe tener al menos 6 caracteres.
    -   Debe contener al menos una letra mayúscula.
    -   Debe contener al menos un número.
-   **Navegación:** Después de una validación exitosa, la aplicación navega a la pantalla `UserListScreen`, pasando el correo electrónico del usuario.

## Estructura del Proyecto

-   `main.dart`: El punto de entrada de la aplicación.
-   `views/login_screen.dart`: La pantalla de inicio de sesión con el formulario y la lógica de validación.
-   `views/user_list_screen.dart`: La pantalla a la que se navega después de un inicio de sesión exitoso.
-   `viewmodels/user_view_model.dart`: El `ViewModel` para la gestión de usuarios.
-   `models/user.dart`: El modelo de datos para un usuario.
