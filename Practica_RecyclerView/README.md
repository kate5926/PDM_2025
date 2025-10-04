# Práctica Guiada: RecyclerView con Edición y Long Click

## Descripción General  
Esta práctica implementa un sistema completo de gestión de usuarios utilizando **RecyclerView** en **Kotlin** con **Android Studio**. La aplicación permite realizar operaciones CRUD mediante eventos táctiles y diálogos personalizados.

### Contenido  
- **RecyclerView** con lista de usuarios  
- **Funcionalidades CRUD** completas (Crear, Leer, Actualizar, Eliminar)  
- **Diálogos personalizados** para edición de datos  
- **Eventos Long Click** para menú contextual  

---

## Requisitos Previos  
- Android Studio (versión recomendada: **Electric Eel 2022.1.1** o superior)  
- Emulador configurado o dispositivo físico con Android 5.0 (API 21) o mayor  
- SDK de Android correctamente instalado  
- Conocimientos básicos de Kotlin y Android Development  

---

## Funcionalidades Principales

### Gestión de Usuarios
- **Agregar usuarios** mediante botón flotante  
- **Editar usuarios** con diálogo personalizado  
- **Validación** de campos de entrada  

### Interacción de Usuario
- **Long Click** en cualquier usuario para mostrar menú  
- **Diálogos personalizados** para entrada de datos  
- **Actualizaciones en tiempo real** de la lista  
- **Feedback visual** con mensajes Toast  

---

## Archivos Principales

### Código Kotlin
- `MainActivity.kt` → Actividad principal y lógica de negocio  
- `UsuarioAdapter.kt` → Adaptador personalizado del RecyclerView  
- `Usuario.kt` → Modelo de datos para usuarios  
- `UsuarioProvider.kt` → Fuente de datos de usuarios  

### Layouts XML
- `activity_main.xml` → Vista principal con RecyclerView  
- `item_usuario.xml` → Diseño de cada elemento de la lista  
- `dialog_edit_usuario.xml` → Formulario de edición personalizado  

### Recursos
- `strings.xml` → Textos y mensajes de la aplicación  
- `colors.xml` → Paleta de colores de la interfaz  
- `drawable/` → Iconos y elementos gráficos  

---


