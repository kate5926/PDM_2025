# Práctica 3 – Aplicaciones Básicas en Android  

## Descripción General  
Este repositorio incluye dos ejercicios prácticos desarrollados en **Kotlin** con **Android Studio**.  

### Contenido  
- **Ejercicio 1:** Aplicación interactiva con imágene 
- **Ejercicio 2:** Reproductor de música simple  

---

## Requisitos Previos  
- Android Studio (versión recomendada: **Meerkat 2024.3.1** o superior).  
- Emulador configurado o dispositivo físico con Android 5.0 (API 21) o mayor.  
- SDK de Android correctamente instalado.  

---

## Ejercicio 1 – Imagen Interactiva  

### Objetivo  
Construir una app sencilla que muestre una imagen en pantalla y responda a la interacción del usuario.  

### Funcionalidad  
- Se presenta una **imagen centrada** en la interfaz.  
- Al presionar la imagen, se despliega un mensaje **Toast** con texto personalizado.  
- Diseño creado con **ConstraintLayout** para mantener compatibilidad y adaptabilidad.  

### Archivos Principales  
- `MainActivity.kt` → Maneja el evento de clic en la imagen.  
- `activity_main.xml` → Contiene el diseño con un `ImageView`.  
- `AndroidManifest.xml` → Configuración inicial de la aplicación.  

### Ejecución  
1. Abrir el proyecto en Android Studio.  
2. Ejecutar en un emulador o dispositivo.  
3. Presionar la imagen para ver el mensaje emergente.  

---

## Ejercicio 2 – Reproductor de Música  

### Objetivo  
Implementar un reproductor que permita reproducir audio desde los recursos locales del proyecto.  

### Funcionalidad  
- Botones para **Reproducir**, **Pausar** y **Detener**.  
- Reproducción de un archivo de audio ubicado en la carpeta `res/raw/`.  
- Uso de **MediaPlayer** para manejar el ciclo de vida del sonido.  
- Interfaz sencilla e intuitiva para el usuario.  

### Archivos Principales  
- `MainActivity.kt` → Controla el reproductor de música.  
- `activity_main.xml` → Layout con los botones de control.  
- `res/raw/` → Archivos de audio en formato `.mp3` o `.wav`.  

### Ejecución  
1. Abrir el proyecto en Android Studio.  
2. Iniciar la app en un dispositivo o emulador.  
3. Usar los botones de control para reproducir el audio.  

---

## Cómo Probar  
- Abrir la carpeta del ejercicio en Android Studio.  
- Asegurarse de tener configurado el SDK y un emulador.  
- Ejecutar con el botón **Run (▶)**.  

