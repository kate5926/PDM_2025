
/*
Descripción: Clase para Producto: Diseña una clase Producto que tenga un precio
 y un descuento aplicable. Implementa métodos set y get para establecer y obtener
 el precio y el descuento, y añade un método para calcular el precio final después
                                         de aplicar el descuento. Utilice el set para validar datos.

Autor:
Fecha creación: 31/08/2025
Fecha última modificación: 31/08/2025
*/

class Producto {
  //Precio 
   var precio: Double = 0.0
        set(value) {
            require(value > 0) { "El precio debe ser mayor que 0." }
            field = value
        }
        get() { return field }   

    // Descuento, debe estar entre 0 y 100
   var descuento: Double = 0.0
        set(value) {
            require(value in 0.0..100.0) { "El descuento debe estar entre 0% y 100%." }
            field = value
        }
        get() { return field } 

    // Método para calcular el precio final con el descuento aplicado
    fun calcularPrecioFinal(): Double {
        return precio - (precio * descuento / 100)
    }

   

fun main() {
    val producto = Producto()
    var opcion: Int

do {
        println("\n--- MENÚ PRODUCTO ---")
        println("1. Ingresar precio base ")
        println("2. Ingresar descuento ")
        println("3. Mostrar precio final")
        println("4. Mostrar precio y descuento ")
        println("5. Salir")
        print("Seleccione una opción: ")

        opcion = readLine()?.toIntOrNull() ?: 0

        when (opcion) {
            1 -> {
                print("Ingrese el precio base: ")
                val valor = readLine()?.toDoubleOrNull()
                try {
                    if (valor != null) producto.precio = valor
                } catch (e: IllegalArgumentException) {
                    println(" ${e.message}")
                }
            }
            2 -> {
                print("Ingrese el descuento (%): ")
                val valor = readLine()?.toDoubleOrNull()
                try {
                    if (valor != null) producto.descuento = valor
                } catch (e: IllegalArgumentException) {
                    println(" ${e.message}")
                }
            }
            3 -> println("El precio final con descuento es: ${producto.calcularPrecioFinal()}")
            4 -> {
                println("Precio actual : ${producto.precio}")
                println("Descuento actual : ${producto.descuento}%")
            }
            5 -> println("Saliendo del sistema de productos...")
            else -> println("Opción inválida.")
        }
    } while (opcion != 5)
}
