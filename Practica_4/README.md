# Práctica 4 – Comunicación entre Actividades

Proyecto desarrollado en **Android Studio** con **Kotlin**, siguiendo los lineamientos de la práctica guiada.  
Se implementan **dos aplicaciones independientes** (A y B), cada una con su propio flujo y actividades.

---

## Objetivo
Practicar la **comunicación entre actividades** en Android mediante:
- Uso de `Intent` y `Serializable`.
- Envío y recepción de datos con `setResult` y `registerForActivityResult`.
- Conservación de datos con `onSaveInstanceState`.
- Manejo de botones y navegación básica.

---

## Estructura del proyecto
- `EditorPerfil_A/` → App A: Editor de perfil con confirmación.  
- `EditorNota_B/` → App B: Editor de nota rápida.  

---

## A – Editor de Perfil con Confirmación
### bjetivo
Permitir al usuario llenar un perfil, visualizarlo y confirmar los datos.

### Funcionalidad
1. **FormularioActivity**
   - Campos: Nombre, Edad, Ciudad, Correo.
   - Botón "Continuar" → envía los datos a la segunda actividad.
2. **ResumenActivity**
   - Muestra el resumen del perfil.
   - Botones:
     - **Confirmar** → vuelve al inicio y muestra un Toast: *"Perfil guardado correctamente"*.  
     - **Volver a editar** → regresa al formulario para modificar los datos.

### Conceptos aplicados
- Clase `Usuario` como `data class` implementando `Serializable`.
- Envío de datos con `Intent`.
- Manejo de rotación con `onSaveInstanceState`.

---

##  B – Editor de Nota Rápida
### Objetivo
Permitir al usuario escribir una nota, enviarla a otra actividad y decidir compartirla o editarla.

### 🔹 Funcionalidad
1. **EditorActivity**
   - Campo de texto para escribir nota.
   - Botón "Compartir" → envía la nota a la segunda actividad.
2. **OpcionesActivity**
   - Muestra la nota recibida.
   - Botones:
     - **Compartir por correo** → muestra un Toast: *"Compartido por correo"*.  
     - **Editar de nuevo** → regresa la nota para seguir editando.

### Conceptos aplicados
- Comunicación con `Intent.putExtra`.
- Retorno de datos con `setResult` y `registerForActivityResult`.
- Conservación del texto con `onSaveInstanceState`.

---

## Requisitos técnicos
- Android Studio Iguana+  
- Kotlin 1.9+  
- Gradle 8.7+  
- SDK mínimo: API 24 (Android 7.0 Nougat)

---

## Ejecución
1. Abrir el proyecto en Android Studio.
2. Seleccionar el módulo deseado (`EditorPerfil_A` o `EditorNota_B`).
3. Compilar y ejecutar en un dispositivo/emulador.

---


