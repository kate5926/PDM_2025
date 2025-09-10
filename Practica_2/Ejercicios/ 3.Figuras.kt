/*
Descripción: Clase abstracta Shape que tiene área y perímetro.
Se crean subclases Cuadrado, Círculo y Rectángulo,
cada una calcula su área y perímetro.
Autor: katherine Saico
Fecha creación: 31/09/2025
Fecha última modificación: 01/09/2025
*/

// Clase abstracta base
abstract class Shape {
    abstract var area: Double
    abstract var perimetro: Double

    abstract fun calcularArea()
    abstract fun calcularPerimetro()

    fun mostrarResultados() {
        println("Área: $area")
        println("Perímetro: $perimetro")
    }
}

// Subclase Cuadrado
class Cuadrado(private val lado: Double) : Shape() {
    override var area: Double = 0.0
    override var perimetro: Double = 0.0

    override fun calcularArea() {
        area = lado * lado
    }

    override fun calcularPerimetro() {
        perimetro = 4 * lado
    }
}

// Subclase Rectángulo
class Rectangulo(private val base: Double, private val altura: Double) : Shape() {
    override var area: Double = 0.0
    override var perimetro: Double = 0.0

    override fun calcularArea() {
        area = base * altura
    }

    override fun calcularPerimetro() {
        perimetro = 2 * (base + altura)
    }
}

// Subclase Círculo con constructor secundario
class Circulo private constructor(private val radio: Double) : Shape() {
    override var area: Double = 0.0
    override var perimetro: Double = 0.0

    // Constructor secundario
    constructor(diametro: Double, dummy: Boolean = true) : this(diametro / 2)

    override fun calcularArea() {
        area = Math.PI * radio * radio
    }

    override fun calcularPerimetro() {
        perimetro = 2 * Math.PI * radio
    }
}

fun main() {
    // cuadrado
    val cuadrado = Cuadrado(5.0)
    cuadrado.calcularArea()
    cuadrado.calcularPerimetro()
    println("\n--- CUADRADO ---")
    cuadrado.mostrarResultados()

    //  rectángulo
    val rectangulo = Rectangulo(4.0, 6.0)
    rectangulo.calcularArea()
    rectangulo.calcularPerimetro()
    println("\n--- RECTÁNGULO ---")
    rectangulo.mostrarResultados()

    //  círculo (usando radio)
    val circulo = Circulo(7.0)
    circulo.calcularArea()
    circulo.calcularPerimetro()
    println("\n--- CÍRCULO (con radio) ---")
    circulo.mostrarResultados()

    //  círculo (usando diámetro y constructor secundario)
    val circulo2 = Circulo(14.0, true)
    circulo2.calcularArea()
    circulo2.calcularPerimetro()
    println("\n--- CÍRCULO (con diámetro) ---")
    circulo2.mostrarResultados()
}
