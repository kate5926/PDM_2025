# Práctica de Clase: Ciclo de Vida de una Activity en Android

## Descripción

Esta práctica es un ejercicio simple para demostrar y entender el **ciclo de vida de una `Activity`** en Android. La aplicación consiste en una pantalla con un contador y un botón. Cada vez que el botón es presionado, el contador se incrementa.

## Objetivo Académico

El objetivo principal de esta práctica es observar cómo se comportan los diferentes estados del ciclo de vida de una `Activity` y cómo el sistema operativo Android gestiona la persistencia del estado de la aplicación.

## Funcionalidades Implementadas

- **Contador:** Un contador simple que se incrementa al presionar un botón.
- **Logs y Toasts del Ciclo de Vida:** La aplicación muestra mensajes de `Log` y `Toast` para cada uno de los siguientes métodos del ciclo de vida, permitiendo observar cuándo son invocados:
    - `onCreate`
    - `onStart`
    - `onResume`
    - `onPause`
    - `onStop`
    - `onDestroy`
- **Persistencia de Estado:** Se utilizan los métodos `onSaveInstanceState` y `onRestoreInstanceState` para guardar y recuperar el valor del contador cuando la `Activity` es destruida y recreada por el sistema (por ejemplo, al rotar la pantalla).

## Cómo Probar

1.  Ejecuta la aplicación en un emulador o dispositivo Android.
2.  Presiona el botón para incrementar el contador.
3.  Observa los mensajes de Logcat o los Toasts que aparecen en la pantalla para ver los eventos del ciclo de vida.
4.  Rota el dispositivo para simular la destrucción y recreación de la `Activity`. El valor del contador debería persistir.
5.  Navega fuera de la aplicación y vuelve para observar los métodos `onPause`, `onStop`, `onStart`, y `onResume`.
