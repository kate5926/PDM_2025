/**
  Problema 1: Escribir un programa que lea la puntuación del usuario y su
salario mensual e imprima su nivel de rendimiento, así como la cantidad de dinero
que recibirá el usuario. Ejemplo: Salario 10,000; Puntuación 8. Dinero = 10,000 *
(8/10)= 8000. Resultado: Nivel de Rendimiento Aceptable, Cantidad de Dinero
Recibido $8000.   
 
 */


fun evaluacionEmpleado(salario: Double, puntuacion: Double) {
    // Cálculo del dinero a recibir según la puntuación
    val dinero = salario * (puntuacion / 10)

    // Determinar nivel de rendimiento
    val nivel = when (puntuacion) {
        in 0.0..3.0 -> "Inaceptable"
        in 4.0..6.0 -> "Aceptable"
        in 7.0..10.0 -> "Meritorio"
        else -> "Puntuación no válida"
    }

    // Mostrar los resultados
    println("=== Evaluación del Empleado ===")
    println("Nivel de rendimiento: $nivel")
    println("Cantidad de dinero recibido: $$dinero")
}

fun main() {
    print("Ingrese su salario mensual: ")
    val salario = readln().toDouble()

    print("Ingrese su puntuación (0-10): ")
    val puntuacion = readln().toDouble()

    evaluacionEmpleado(salario, puntuacion)
}


