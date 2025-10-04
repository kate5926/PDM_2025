# Práctica 5: Fragments y Navegación  
Configurador de pedido de comida

---

## Descripción
Este proyecto implementa un flujo de pedido de comida utilizando Fragments y el componente de Navegación en Android.  
El usuario puede armar su pedido paso a paso, seleccionando la comida principal, los extras, y revisando un resumen antes de confirmar o editar el pedido.

---

## Objetivo
- Practicar el uso de Fragments en Android Studio.  
- Aprender a navegar entre fragments con `NavController` y `NavGraph`.  
- Enviar datos hacia adelante con `Bundle` y recibir datos de regreso con `setFragmentResult()`.  
- Usar `popBackStack()` para volver a un fragmento anterior y recuperar la información.  

---

## Flujo de la Aplicación
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

## Estructura del Proyecto
- `InicioFragment.kt` → Fragmento de bienvenida con botón para iniciar pedido.  
- `SeleccionComidaFragment.kt` → Fragmento con selección de comida principal.  
- `SeleccionExtrasFragment.kt` → Fragmento con selección de extras.  
- `ResumenPedidoFragment.kt` → Fragmento con el resumen del pedido, confirmación o edición.  
- `res/navigation/nav_graph.xml` → Define las rutas de navegación entre fragments.  
- `res/layout/` → Archivos XML para cada fragmento (diseños de pantalla).  
- `res/drawable/` → Imágenes de fondo y personalización de la interfaz.  

---

## Instrucciones de Ejecución
1. Clonar o descargar el repositorio en Android Studio.  
2. Sincronizar el proyecto con Gradle.  
3. Configurar un dispositivo físico o emulador Android.  
4. Ejecutar la aplicación con el botón Run.  
5. Flujo esperado:  
   - Iniciar pedido → Seleccionar comida → Seleccionar extras → Confirmar o Editar.  

---

## Conceptos Practicados
- Navegación entre fragments con `NavController`.  
- Uso de `Bundle` para paso de datos hacia adelante.  
- Uso de `setFragmentResult` y `setFragmentResultListener` para comunicación de regreso.  
- Implementación de `popBackStack()` para volver atrás.  
- Personalización de la interfaz con imágenes de fondo y colores en botones.  

---
