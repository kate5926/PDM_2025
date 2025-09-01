
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
            require(value in 0.0..100.0) { " El descuento debe estar entre 0% y 100%." }
            descuento = value
        }

    // Método para calcular el precio final con el descuento aplicado
    fun calcularPrecioFinal(): Double {
        return precio - (precio * descuento / 100)
    }

    // Método para mostrar toda la información del producto
    fun mostrarProducto() {
        println("\n--- INFORMACIÓN DEL PRODUCTO ---")
        println("Precio base: $precio")
        println("Descuento: $descuento%")
        println("Precio final: ${calcularPrecioFinal()}")
    }
}

fun main() {
    val producto = Producto()
    var opcion: Int

    do {
        println("\n--- MENÚ PRODUCTO ---")
        println("1. Establecer precio base")
        println("2. Establecer descuento")
        println("3. Ver precio final")
        println("4. Ver información completa")
        println("5. Salir")
        print("Opción: ")

        opcion = readLine()?.toIntOrNull() ?: 0

        when (opcion) {
            1 -> {
                print("Ingrese el precio base: ")
                producto.precio = readLine()?.toDoubleOrNull() ?: 0.0
            }
            2 -> {
                print("Ingrese el descuento (%): ")
                producto.descuento = readLine()?.toDoubleOrNull() ?: 0.0
            }
            3 -> {
                println("El precio final es: ${producto.calcularPrecioFinal()}")
            }
            4 -> producto.mostrarProducto()
            5 -> println("Saliendo del sistema de productos...")
            else -> println("Opción inválida.")
        }
    } while (opcion != 5)
}
