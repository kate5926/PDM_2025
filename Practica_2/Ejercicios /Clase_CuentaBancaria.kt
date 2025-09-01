/*
Descripción:  Clase CuentaBancaria con saldo y límite de retiro, incluye validación en setters, 
métodos para depositar, retirar y mostrar el saldo. 
Autor: katherine Saico
Fecha creación: 31/08/2025
Fecha última modificación: 31/08/25
*/

class CuentaBancaria(limiteInicial: Double) {

    // Variable Saldo con set para evitar que acepte valores negativos
    var saldo: Double = 0.0
        set(value) {
            if (value >= 0) field = value //
            else println(" Tu saldo no puede ser negativo")
        }
        
   // Variable LimiteRetiro validamos que sea mayor a cero
    var limiteRetiro: Double = 0.0
        set(value) {
            if (value > 0) field = value
            else println(" El límite del retiro debe ser mayor que 0.")
        }
        get() = field
   // Inint sirve para asignar el valor del limite al crear la cuenta
    init {
        limiteRetiro = limiteInicial
    }

    // Método para depositar dinero
    fun depositar(monto: Double) {
        if (monto > 0) {
            saldo += monto
            println(" Depósito exitoso. Saldo actual: $saldo")
        } else {
            println(" El Monto es inválido.")
        }
    }

    // Método para retirar dinero considerando su límite y el saldo
    fun retirar(monto: Double) {
        when {
            monto <= 0 -> println("Monto inválido.") 
            monto > saldo -> println(" Saldo insuficiente. Saldo disponible: $saldo")
            monto > limiteRetiro -> println("El monto excede el límite del retiro: $limiteRetiro")
            else -> {
                saldo -= monto
                println("Retiro exitoso. Saldo actual: $saldo")
            }
        }
    }

    // Método para consultar saldo
    fun verSaldo() {
        println(" Saldo actual: $saldo")
    }
}

fun main() {
    val cuenta = CuentaBancaria(500.0) // límite de retiro
    cuenta.saldo = 1000.0              // saldo inicial

    var opcion: Int
    do {
        println("\n--- MENÚ BANCO ---")
        println("1. Ver saldo")
        println("2. Depositar")
        println("3. Retirar")
        println("4. Salir")
        print("Opción: ")

        opcion = readLine()?.toIntOrNull() ?: 0

        when (opcion) {
            1 -> cuenta.verSaldo()
            2 -> {
                print("Monto a depositar: ")
                val monto = readLine()?.toDoubleOrNull() ?: 0.0
                cuenta.depositar(monto)
            }
            3 -> {
                print("Monto a retirar: ")
                val monto = readLine()?.toDoubleOrNull() ?: 0.0
                cuenta.retirar(monto)
            }
            4 -> println(" Saliendo de la Cuenta Bancaria...")
            else -> println("Error.")
        }
    } while (opcion != 4) //Se repite hasta que se elija Salir
}

