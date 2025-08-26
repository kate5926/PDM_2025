import kotlin.random.Random

fun main() {
    // Genera un número aleatorio entre 1 y 30
    val numSecret = Random.nextInt(1, 31)
    var intentos = 0
    val maxIntentos = 5
    var adivinado = false

    println("Adivina el número (entre 1 y 30)")
    println("Tienes esto $maxIntentos de intentos")

    // Ciclo para dar los intentos
    while (intentos < maxIntentos && !adivinado) {
        print("Ingresa tu número: ")
        val intento = readln().toInt()
        intentos++

        // Revisamos si el número es correcto
        if (intento == numSecret) {
            println(" Adivinaste el número en $intentos intentos")
            adivinado = true
        } else if (intento < numSecret) {
            println("El número secret0 es MAYOR")
        } else {
            println("El número secreto es MENOR")
        }
    }

    // Si no adivina en los intentos
    if (!adivinado) {
        println("Game Overrr el número era $numSecret")
    }
}

