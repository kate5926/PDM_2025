# Práctica 2 – Programación Orientada a Objetos en Kotlin

Este repositorio contiene la segunda práctica de la asignatura, enfocada en el uso de **POO en Kotlin**.  
Se desarrollaron **cuatro ejercicios independientes**, cada uno aplicando conceptos de clases, herencia, polimorfismo, encapsulamiento, interfaces y manejo de datos.

---

##  Contenido de la práctica

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

---

## Ejecución de los programas

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

## Requisitos técnicos

- Kotlin SDK 
- Java instalado en el sistema.  
- Entorno recomendado: IntelliJ IDEA Community Edition.  

---

##  Notas importantes

- Todos los programas utilizan **clases y POO** como lo solicita la práctica.  
- Se incluyeron validaciones básicas para evitar datos inválidos.  
- El sistema de biblioteca incluye datos de ejemplo precargados y un menú de opciones para facilitar las pruebas.  

---
