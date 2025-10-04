/**
Problema 2: Escriba un programa que realice el juego de piedra, papel o
tijera. La computadora debe elegir de manera aleatoria la opción a elegir. Después
debe preguntar al usuario que opción quiere. Imprimir si ganó, perdió o empató.

 */
import kotlin.random.Random

// Función principal
fun jugar(usuario: String) {
    
    // Lista de opsibles opciones del juego
    val opciones = listOf("piedra", "papel", "tijera")
    
    // La computadora elige aleatoriamente una de las opciones
    val eleccionComputadora = opciones[Random.nextInt(opciones.size)]

    println("La computadora eligió: $eleccionComputadora")

    // Comparación entre la elección del usuario y la computadora
    val resultado = when {
        usuario == eleccionComputadora -> "Empate"
        (usuario == "piedra" && eleccionComputadora == "tijera") ||
        (usuario == "papel" && eleccionComputadora == "piedra") ||
        (usuario == "tijera" && eleccionComputadora == "papel") -> "Ganaste"
        else -> "Perdiste"
    }

    // resultado 
    println("Resultado: $resultado")
}

fun main() {
    // Mensajes
    println("=== Juego: Piedra, Papel o Tijera ===")
    print("Elige una opción (piedra, papel, tijera): ")
    val usuario = readln().lowercase()

    // Llamar a la función para iniciar el juego
    jugar(usuario)
}

