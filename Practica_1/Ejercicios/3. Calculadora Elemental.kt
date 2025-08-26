


fun Menu() {
    println("==== Menú ====")
    println("1. Suma")
    println("2. Resta")
    println("3. Multiplicacion")
    println("4. Division")
    println("5. Salir")
}

// Función que  realiza la operación  elegida
fun calcular(opcion: Int, num1: Double, num2: Double): Double {
    return when (opcion) {
        1 -> num1 + num2
        2 -> num1 - num2
        3 -> num1 * num2
        4 -> if (num2 != 0.0) num1 / num2 else Double.NaN
        else -> Double.NaN
    }
}

fun main() {
    var opcion: Int

    do {
        Menu()
        print("Seleccione una opción: ")
        opcion = readln().toInt()

        if (opcion in 1..4) {
            print("Ingrese el primer número: ")
            val num1 = readln().toDouble()

            print("Ingrese el segundo número: ")
            val num2 = readln().toDouble()

            val resultado = calcular(opcion, num1, num2)
            if (resultado.isNaN()) {
                println("Error")
            } else {
                println("Resultado: $resultado")
            }
        } else if (opcion != 5) {
            println("Opcion no válida")
        }

    } while (opcion != 5)

    println("FIN")
}
