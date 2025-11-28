# PDM_2025  

Dispositivos Móviles  
Katherine Saico  

# Resumen de Prácticas del Curso

Este repositorio contiene un conjunto de prácticas desarrolladas en Kotlin y Flutter, que abarcan desde conceptos básicos de programación hasta el desarrollo de aplicaciones para Android.

---
---

## Práctica 1: Fundamentos de Kotlin

### Descripción
Esta practica contiene cuatro ejercicios desarrollados en **Kotlin**, cada uno diseñado para aplicar conceptos básicos del lenguaje mediante programas interactivos.

#### Ejercicios incluidos:
- Evaluación de empleados
- Juego de Piedra, Papel o Tijera
- Calculadora elemental
- Adivina el Número

### Requisitos
- Entorno para el desarrollo (IntelliJ IDEA )
- SDK de Kotlin

### Estructura del Proyecto

#### Ejercicio 1: Evaluación de Empleados
**Descripción:**
Programa que calcula el nivel de rendimiento y la cantidad de dinero adicional que recibe un empleado según su puntuación de evaluación (0 a 10).

- 0–3: **Inaceptable**
- 4–6: **Aceptable**
- 7–10: **Meritorio**

**Flujo de ejecución:**
1. Ejecutar el programa.
2. Ingresar el salario base.
3. Ingresar la puntuación de desempeño.
4. Recibe nivel de rendimiento y cantidad de dinero .

#### Ejercicio 2: Piedra, Papel o Tijera
**Descripción:**
Es un juego contra la computadora. El usuario selecciona una opción y la computadora elige otra aleatoriamente.

**Flujo de ejecución:**
1. Ejecutar el programa.
2. Seleccionar opción:
   - 1: Piedra
   - 2: Papel
   - 3: Tijera
3. resultado (ganar, perder o empatar).

#### Ejercicio 3: Calculadora Elemental
**Descripción:**
Calculadora básica que puede suma, resta, multiplicación y división. Incluye un menú con opción para salir.

**Flujo de ejecución:**
1. Ejecutar el programa.
2. Seleccionar una opción del menú:
   - 1: Suma
   - 2: Resta
   - 3: Multiplicación
   - 4: División
   - 5: Salir
3. Ingresar valores y visualizar resultado.

#### Ejercicio 4: Adivina el Número
**Descripción:**
Juego en el que el usuario debe adivinar un número aleatorio entre 1 y 30. El juego tiene 5 intentos para lograrlo.

**Flujo de ejecución:**
1. Iniciar el juego.
2. Ingresar un número (1–30).
3. Recibir pistas: "mayor" o "menor".
4. Ganas si adivinas el número o pierdes si se acaban los intentos.

---
---

## Práctica 2: Programación Orientada a Objetos en Kotlin

Este repositorio contiene la segunda práctica de la asignatura, enfocada en el uso de **POO en Kotlin**.
Se desarrollaron **cuatro ejercicios independientes**, cada uno aplicando conceptos de clases, herencia, polimorfismo, encapsulamiento, interfaces y manejo de datos.

### Contenido de la práctica

1. **Cuenta Bancaria**
   Implementación de una clase que simula operaciones básicas de una cuenta.
   - Atributos: saldo y límite de retiro.
   - Métodos: setters y getters con validación, y un método para realizar retiros considerando el límite.

2. **Producto con Descuento**
   Clase que permite calcular el precio final de un producto aplicando un porcentaje de descuento.
   - Valida que el precio sea positivo y el descuento esté en un rango permitido (0–100).
   - Incluye función de cálculo y métodos para mostrar resultados.

3. **Figuras Geométricas**
   Jerarquía de clases usando una clase abstracta `Shape`.
   - Define propiedades para área y perímetro.
   - Subclases: `Cuadrado`, `Rectángulo` y `Círculo`.
   - Cada clase implementa sus fórmulas y permite imprimir los resultados.

4. **Sistema de Biblioteca**
   Programa completo que gestiona materiales y usuarios de una biblioteca.
   - Clases: `Material` (abstracta), `Libro`, `Revista`, `Usuario`.
   - Interfaz: `IBiblioteca` con las operaciones de registro, préstamo y devolución.
   - Clase `Biblioteca` que implementa la lógica del sistema.
   - Incluye un menú en consola para interactuar con el usuario.

### Ejecución de los programas

Cada ejercicio está en un archivo independiente (`.kt`).
Para ejecutarlos:

1. Abrir el proyecto en **IntelliJ IDEA** (o cualquier IDE compatible con Kotlin).
2. Ir al archivo correspondiente:
   - `CuentaBancaria.kt`
   - `Producto.kt`
   - `Figuras.kt`
   - `Biblioteca.kt`
3. Ejecutar la función `main()` de cada script.
4. Observar la salida en consola según las operaciones programadas.

---
---

## Práctica 3: Aplicaciones Básicas en Android

### Descripción General
Este repositorio incluye dos ejercicios prácticos desarrollados en **Kotlin** con **Android Studio**.

#### Contenido
- **Ejercicio 1:** Aplicación interactiva con imágene
- **Ejercicio 2:** Reproductor de música simple

### Ejercicio 1: Imagen Interactiva

#### Objetivo
Construir una app sencilla que muestre una imagen en pantalla y responda a la interacción del usuario.

#### Funcionalidad
- Se presenta una **imagen centrada** en la interfaz.
- Al presionar la imagen, se despliega un mensaje **Toast** con texto personalizado.
- Diseño creado con **ConstraintLayout** para mantener compatibilidad y adaptabilidad.

### Ejercicio 2: Reproductor de Música

#### Objetivo
Implementar un reproductor que permita reproducir audio desde los recursos locales del proyecto.

#### Funcionalidad
- Botones para **Reproducir**, **Pausar** y **Detener**.
- Reproducción de un archivo de audio ubicado en la carpeta `res/raw/`.
- Uso de **MediaPlayer** para manejar el ciclo de vida del sonido.
- Interfaz sencilla e intuitiva para el usuario.

---
---

## Práctica 4: Comunicación entre Actividades

Proyecto desarrollado en **Android Studio** con **Kotlin**, siguiendo los lineamientos de la práctica guiada.
Se implementan **dos aplicaciones independientes** (A y B), cada una con su propio flujo y actividades.

### Objetivo
Practicar la **comunicación entre actividades** en Android mediante:
- Uso de `Intent` y `Serializable`.
- Envío y recepción de datos con `setResult` y `registerForActivityResult`.
- Conservación de datos con `onSaveInstanceState`.
- Manejo de botones y navegación básica.

### A – Editor de Perfil con Confirmación
#### Objetivo
Permitir al usuario llenar un perfil, visualizarlo y confirmar los datos.

#### Funcionalidad
1. **FormularioActivity**
   - Campos: Nombre, Edad, Ciudad, Correo.
   - Botón "Continuar" → envía los datos a la segunda actividad.
2. **ResumenActivity**
   - Muestra el resumen del perfil.
   - Botones:
     - **Confirmar** → vuelve al inicio y muestra un Toast: *"Perfil guardado correctamente"*.
     - **Volver a editar** → regresa al formulario para modificar los datos.

### B – Editor de Nota Rápida
#### Objetivo
Permitir al usuario escribir una nota, enviarla a otra actividad y decidir compartirla o editarla.

#### Funcionalidad
1. **EditorActivity**
   - Campo de texto para escribir nota.
   - Botón "Compartir" → envía la nota a la segunda actividad.
2. **OpcionesActivity**
   - Muestra la nota recibida.
   - Botones:
     - **Compartir por correo** → muestra un Toast: *"Compartido por correo"*.
     - **Editar de nuevo** → regresa la nota para seguir editando.

---
---

## Práctica de Clase: Ciclo de Vida de una Activity en Android

### Descripción

Esta práctica es un ejercicio simple para demostrar y entender el **ciclo de vida de una `Activity`** en Android. La aplicación consiste en una pantalla con un contador y un botón. Cada vez que el botón es presionado, el contador se incrementa.

### Objetivo Académico

El objetivo principal de esta práctica es observar cómo se comportan los diferentes estados del ciclo de vida de una `Activity` y cómo el sistema operativo Android gestiona la persistencia del estado de la aplicación.

### Funcionalidades Implementadas

- **Contador:** Un contador simple que se incrementa al presionar un botón.
- **Logs y Toasts del Ciclo de Vida:** La aplicación muestra mensajes de `Log` y `Toast` para cada uno de los siguientes métodos del ciclo de vida, permitiendo observar cuándo son invocados:
    - `onCreate`
    - `onStart`
    - `onResume`
    - `onPause`
    - `onStop`
    - `onDestroy`
- **Persistencia de Estado:** Se utilizan los métodos `onSaveInstanceState` y `onRestoreInstanceState` para guardar y recuperar el valor del contador cuando la `Activity` es destruida y recreada por el sistema (por ejemplo, al rotar la pantalla).

---
---

## Práctica 5: Fragments y Navegación

### Descripción
Este proyecto implementa un flujo de pedido de comida utilizando Fragments y el componente de Navegación en Android.
El usuario puede armar su pedido paso a paso, seleccionando la comida principal, los extras, y revisando un resumen antes de confirmar o editar el pedido.

### Objetivo
- Practicar el uso de Fragments en Android Studio.
- Aprender a navegar entre fragments con `NavController` y `NavGraph`.
- Enviar datos hacia adelante con `Bundle` y recibir datos de regreso con `setFragmentResult()`.
- Usar `popBackStack()` para volver a un fragmento anterior y recuperar la información.

### Flujo de la Aplicación
1. **InicioFragment**
   - Botón: "Nuevo Pedido"
   - Navega a `SeleccionComidaFragment`.
2. **SeleccionComidaFragment**
   - El usuario elige entre Pizza, Hamburguesa o Ensalada.
   - Botón "Siguiente" → Pasa el tipo de comida en un `Bundle` y navega a `SeleccionExtrasFragment`.
3. **SeleccionExtrasFragment**
   - Selección de extras: bebida, papas o postre.
   - Botón "Siguiente" → Agrega los extras al `Bundle` y navega a `ResumenPedidoFragment`.
4. **ResumenPedidoFragment**
   - Muestra la comida y extras seleccionados.
   - Botón "Confirmar pedido": Muestra un Toast y regresa al inicio.
   - Botón "Editar pedido": Usa `setFragmentResult()` y `popBackStack()` para regresar con los datos actuales.

---
---

## Práctica Guiada: RecyclerView con Edición y Long Click

### Descripción General
Esta práctica implementa un sistema completo de gestión de usuarios utilizando **RecyclerView** en **Kotlin** con **Android Studio**. La aplicación permite realizar operaciones CRUD mediante eventos táctiles y diálogos personalizados.

### Funcionalidades Principales

#### Gestión de Usuarios
- **Agregar usuarios** mediante botón flotante
- **Editar usuarios** con diálogo personalizado
- **Validación** de campos de entrada

#### Interacción de Usuario
- **Long Click** en cualquier usuario para mostrar menú
- **Diálogos personalizados** para entrada de datos
- **Actualizaciones en tiempo real** de la lista
- **Feedback visual** con mensajes Toast

---
---

## Práctica: Interfaces Estáticas Flutter

### Sinopsis
Este proyecto es una **aplicación Flutter básica** que presenta tres interfaces estáticas para practicar el uso de widgets como `Text`, `Image`, `Column`, `Row`, `Padding` y `Container`.
Incluye una **pantalla de inicio**, un **perfil personal** y una **lista de hobbies**, sin lógica de navegación ni interacciones.

### Funcionalidades Implementadas

- **Pantalla de inicio:** Muestra un mensaje de bienvenida y un botón (no funcional).
- **Pantalla de perfil:** Incluye una imagen, nombre, descripción personal y datos de contacto con íconos.
- **Pantalla de hobbies:** Lista hobbies con íconos y descripciones, más una imagen adicional.

---
---

## Práctica: Navegación Inferior (BottomNavigationBar) en Flutter
### Objetivo
Implementar un sistema de navegación por pestañas usando BottomNavigationBar en Flutter, comprendiendo la relación entre pantallas, navegación y estado.

### Actividades extra
- Agrega un cuarto tab llamado “Perfil”.
- Dentro del tab “Perfil”, muestra un botón que navegue a una pantalla nueva llamada “Editar perfil”.
- En la pantalla “Editar perfil”, coloca un TextField para capturar el nombre del usuario.
- Usa `Navigator.pop(context, nombre)` para regresar el valor capturado y mostrarlo en el tab “Perfil”.
- Asegúrate de actualizar el estado para reflejar el nombre en pantalla.

---
---

## Práctica: Gestión de Usuarios con Flutter (MVVM + Provider)

Este proyecto implementa un sistema completo de gestión de usuarios usando Flutter, Provider y el patrón MVVM. Incluye CRUD, validaciones, filtro dinámico y una interfaz reactiva sin necesidad de `setState()` manual.

### Características

- **CRUD completo:** Agregar, editar y eliminar usuarios.
- **Campos de usuario:** Nombre, género (Masculino/Femenino), estado (activo/inactivo), edad numérica y correo con validación.
- **Validaciones:** Nombre no vacío, edad mayor a 0, correo con formato válido.
- **Filtro dinámico:** Opción para mostrar solo usuarios activos.
- **UI interactiva:** RadioButton para género, Switch para estado activo y listas que se actualizan automáticamente con Provider.
- **Patrón MVVM:** Separación clara entre Modelo (`User`), ViewModel (`UserViewModel`) y Vistas.
- **Estado reactivo:** Cambios reflejados en tiempo real sin usar `setState()`.

---
---

## Práctica: Pantalla de Login con Validación en Flutter

### Descripción

Este proyecto es una aplicación Flutter que implementa una pantalla de inicio de sesión con validación de campos para correo electrónico y contraseña. Una vez que el usuario ingresa credenciales válidas, es redirigido a una pantalla de lista de usuarios.

### Funcionalidades Implementadas

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

---
---

## Examen Parcial: Juego de Colores

### Descripción del Proyecto
Aplicación móvil desarrollada en Kotlin para Android que implementa un juego interactivo donde el usuario debe identificar y seleccionar colores coincidentes bajo un límite de tiempo.

### Objetivo Académico
Desarrollar una aplicación que demuestre competencias en:
- Navegación entre Fragments
- Gestión del ciclo de vida de componentes Android
- Implementación de lógica de juego interactiva
- Almacenamiento de datos con SharedPreferences
- Diseño de UI responsiva con ConstraintLayout

### Funcionalidades Implementadas

#### Fragmento de Bienvenida (WelcomeFragment)
- Título del juego y mensaje de bienvenida
- AlertDialog automático con instrucciones del juego
- Botón "Iniciar Juego" con animación de pulsación
- Navegación al juego principal

#### Fragmento de Juego (GameFragment)
- Cuadro de color aleatorio (rojo, verde, azul, amarillo, morado, naranja)
- Seis botones de colores para selección
- Temporizador de 30 segundos con cuenta regresiva
- Sistema de puntuación en tiempo real
- Animaciones:  vibración en errores

#### Fragmento de Resultados (ResultFragment)
- Puntaje final de la partida actual
- Mejor puntaje
- Historial de partidas de la sesión (ListView)
- Botón "Jugar Otra Vez"
