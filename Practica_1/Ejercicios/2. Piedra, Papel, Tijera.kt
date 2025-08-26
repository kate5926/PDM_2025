

import kotlin.random.Random

fun jugar(Usuario: String) {
    val obciones = listOf("piedra", "papel", "tijera")
    val eleccionComputadora = obciones[Random.nextInt(obciones.size)]

    println("La computadora eligió: $eleccionComputadora")

    val resultado = when {
        Usuario == eleccionComputadora -> "Empate"
        (Usuario == "piedra" && eleccionComputadora == "tijera") ||
                (Usuario == "papel" && eleccionComputadora == "piedra") ||
                (Usuario == "tijera" && eleccionComputadora == "papel") -> "Ganaste"
        else -> "Perdiste"
    }

    println("Resultado: $resultado")
}

fun main() {
    println("=== Juego: Piedra, Papel o Tijera ===")
    print("Elige una opción (piedra, papel, tijera): ")
    val usuario = readln().lowercase()

    jugar(usuario)
}

