/** ejercicio3: Realizar una calculadora básica suma, resta,
multiplicación, división. Debe imprimir un menú con las opciones incluyendo una
opción salir. 

*/

// Función que muestra el menú 
fun Menu() {
    println("==== Menú ====")
    println("1. Suma")
    println("2. Resta")
    println("3. Multiplicación")
    println("4. División")
    println("5. Salir")
}

// Función que hace la operación  elegida
fun calcular(opcion: Int, num1: Double, num2: Double): Double {
    return when (opcion) {
        1 -> num1 + num2   // suma
        2 -> num1 - num2   // resta
        3 -> num1 * num2   // multiplicación
        4 -> if (num2 != 0.0) num1 / num2 else Double.NaN // división con validación
        else -> Double.NaN // si no es válido
    }
}
//MAIN
fun main() {
    var opcion: Int

    do {
        Menu() // se muestra el menú
        print("Seleccione una opción: ")
        opcion = readln().toInt() // se lee la opción

        if (opcion in 1..4) {
            
            // pedir los dos números
            print("Ingrese el primer número: ")
            val num1 = readln().toDouble()

            print("Ingrese el segundo número: ")
            val num2 = readln().toDouble()

            // calcular y mostrar el resultado
            val resultado = calcular(opcion, num1, num2)
            if (resultado.isNaN()) {
                println("Error: división por cero")
            } else {
                println("Resultado: $resultado")
            }
        } else if (opcion != 5) {
            println("Opción no válida")
        }

    } while (opcion != 5) // repetir hasta elegir salir

    println("FIN")
}
