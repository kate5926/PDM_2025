# practica_6

A new Flutter project.

## Getting Started


# Práctica: Interfaces Estáticas Flutter 

##  Sinopsis
Este proyecto es una **aplicación Flutter básica** que presenta tres interfaces estáticas para practicar el uso de widgets como `Text`, `Image`, `Column`, `Row`, `Padding` y `Container`.  
Incluye una **pantalla de inicio**, un **perfil personal** y una **lista de hobbies**, sin lógica de navegación ni interacciones.

---

## Requisitos
- **Flutter SDK** (versión 3.0 o superior recomendada)  
- **Dart SDK** (incluido con Flutter)  
- **Android Studio** o **Visual Studio Code** con extensiones de Flutter  
- **Dispositivo Android/iOS** físico o emulador  

---

## Estructura del Proyecto

| Archivo | Descripción |
|----------|--------------|
| `main.dart` | Punto de entrada principal de la app. Configura el `MaterialApp` y permite probar cada pantalla cambiando la línea `home`. |
| `pantalla_inicio.dart` | Pantalla de bienvenida con `AppBar`, texto de bienvenida y un botón inactivo. |
| `pantalla_perfil.dart` | Pantalla de perfil con imagen, nombre, descripción e información de contacto organizada en filas con íconos. |
| `pantalla_hobbies.dart` | Pantalla de hobbies con una lista de al menos tres intereses, usando filas con íconos y una imagen opcional. |

---

## Descripción General
Aplicación Flutter simple para practicar **layouts visuales estáticos**.  
Cada pantalla usa `Scaffold`, `AppBar` y widgets básicos para organizar contenido de manera clara y centrada.  
Las imágenes se cargan desde internet usando `Image.network`, y el diseño es responsive con `Padding` y `SizedBox` para espaciado.

---

## Funcionalidades Implementadas

- **Pantalla de inicio:** Muestra un mensaje de bienvenida y un botón (no funcional).  
- **Pantalla de perfil:** Incluye una imagen, nombre, descripción personal y datos de contacto con íconos.  
- **Pantalla de hobbies:** Lista hobbies con íconos y descripciones, más una imagen adicional.  

---

## Tecnologías y Patrones Utilizados

- **Flutter Framework** para desarrollo multiplataforma.  
- **Widgets Stateless** para interfaces sin estado.  
- **Image.network** para cargar imágenes desde URLs con manejo básico de errores (`errorBuilder` opcional).  
- **Column** y **Row** para layouts flexibles.  
- **Padding**, **Center** y **SizedBox** para espaciado y alineación.  
- **Scaffold** y **AppBar** para estructura básica de pantallas.

---

## Instrucciones de Configuración

1. Clona o descarga el proyecto en tu máquina
2. Asegúrate de tener Flutter instalado:

- flutter doctor
## Cómo Usar la Aplicación

Al iniciar, verás la pantalla configurada en main.dart (por defecto, PantallaInicio).

Para probar otras pantallas, cambia la línea:PantallaInicio(),PantallaPerfil(), PantallaHobbies()

No hay navegación entre pantallas; se cambia manualmente para ver cada interfaz.

## Funcionalidades Adicionales

Diseño visual básico: Uso de colores en AppBar y espaciado para claridad.

Manejo de imágenes: Carga desde internet con ajuste de tamaño (fit: BoxFit.cover).

Responsive: Se adapta a pantallas con Padding y alineaciones flexibles.

## Notas Técnicas

Las imágenes usan Image.network; si fallan, Flutter muestra un error (podemos agregar errorBuilder para íconos personalizados).

Widgets organizados en Column y Row para layouts simples.


## Dificultades y Problemas Encontrados

Durante el desarrollo se presentaron algunos desafíos comunes en Flutter:

1. Instalación de Flutter
Problemas con la configuración del PATH en Windows/macOS; se solucionó agregando manualmente las rutas de Flutter/bin y Dart/bin al sistema.

-  Solución: ejecutar flutter doctor para diagnosticar y seguir las guías oficiales.

2.  Emulador
La configuración inicial en Android Studio fue lenta; aparecieron errores de virtualización (VT-x/AMD-V deshabilitado).

- Solución: habilitar la virtualización 
3. Carga de imágenes
Algunas URLs inválidas causaban errores en la carga.

- Solución: usar imágenes HTTPS y sitios públicos (por ejemplo, Unsplash). Se agregó errorBuilder para manejar fallos de carga.

4. Compatibilidad visual
En emuladores antiguos, algunos widgets se veían distorsionados.

-  Solución: ajustar tamaños con MediaQuery y SizedBox para una mejor adaptación a pantallas pequeñas.
