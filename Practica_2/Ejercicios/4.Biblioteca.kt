/**
 * Descripción del problema:
 *   Se desea desarrollar un sistema básico de gestión de biblioteca
 *   que permita registrar materiales y usuarios, prestar y devolver
 *   materiales, y mostrar la disponibilidad.
 *
 * Autor:        Katherine Saico
 * Fecha:        70/09/2025
 */

// Clase abstracta base
abstract class Material(
    val titulo: String,
    val autor: String,
    val anio: Int
) {
    abstract fun mostrarInfo()
}

// Clase que representa un libro, hereda de Material
class Libro(
    titulo: String,
    autor: String,
    anio: Int,
    val genero: String,
    val paginas: Int
) : Material(titulo, autor, anio) {
    override fun mostrarInfo() {
        println("Libro: $titulo | Autor: $autor | Año: $anio | Género: $genero | Páginas: $paginas")
    }
}

// Subclase  Revista
class Revista(
    titulo: String,
    autor: String,
    anio: Int,
    val issn: String,
    val volumen: Int,
    val numero: Int
) : Material(titulo, autor, anio) {
    override fun mostrarInfo() {
        println(" Revista: $titulo | ISSN: $issn | Volumen: $volumen | Número: $numero | Año: $anio")
    }
}
// Clase de datos para guardar la información de un usuario
data class Usuario(
    val nombre: String,
    val apellido: String,
    val edad: Int
)

// Interfaz d
interface IBiblioteca {
    fun agregarMaterial(material: Material)    
    fun agregarUsuario(usuario: Usuario)
    fun prestar(material: Material, usuario: Usuario)
    fun devolver(material: Material, usuario: Usuario)
    fun listarMateriales()
    fun listarPrestamos(usuario: Usuario)
}

// Implementación
class Biblioteca : IBiblioteca {
    private val disponibles = mutableListOf<Material>()  // Lista de materiales disponibles para préstamo
    private val usuarios = mutableListOf<Usuario>()          // Lista de usuarios registrados
    private val prestamos = mutableMapOf<Usuario, MutableList<Material>>()   // Relación de usuario con los materiales que tiene en préstamo

    override fun agregarMaterial(material: Material) {
        disponibles.add(material)      // Agrega un material nuevo a la biblioteca
    }

    override fun agregarUsuario(usuario: Usuario) {    // Registra un nuevo usuario y lo inicializa sin préstamos
        usuarios.add(usuario)
        prestamos[usuario] = mutableListOf()
    }

    override fun prestar(material: Material, usuario: Usuario) {      // Realiza un préstamo si el material está disponible
        if (disponibles.remove(material)) {
            prestamos[usuario]?.add(material)
            println("Préstamo realizado: '${material.titulo}' para ${usuario.nombre}")
        } else {
            println("No se pudo realizar el préstamo.")
        }
    }

    override fun devolver(material: Material, usuario: Usuario) {    // Devuelve un material prestado, regresándolo a la lista de disponibles
        if (prestamos[usuario]?.remove(material) == true) {
            disponibles.add(material)
            println("Devolución realizada: '${material.titulo}' de ${usuario.nombre}")
        } else {
            println(" Ese material no está en préstamo por este usuario.")
        }
    }

    override fun listarMateriales() {       // Muestra todos los materiales disponibles
        println("\n Materiales en la biblioteca:")
        if (disponibles.isEmpty()) println(" - Ninguno disponible")
        else disponibles.forEach { it.mostrarInfo() }
    }

    override fun listarPrestamos(usuario: Usuario) {   // Muestra los préstamos de un usuario en particular
        println("\n Materiales prestados a ${usuario.nombre}:")
        val lista = prestamos[usuario]
        if (lista.isNullOrEmpty()) println(" - Ninguno")
        else lista.forEach { it.mostrarInfo() }
    }

    // Métodos auxiliares
    fun buscarUsuario(nombre: String, apellido: String): Usuario? {
        return usuarios.find { it.nombre == nombre && it.apellido == apellido }
    }

    fun buscarMaterial(titulo: String): Material? {
        return disponibles.find { it.titulo == titulo }
    }
}

// ---------------- MAIN CON MENÚ ----------------
fun main() {
    val biblioteca = Biblioteca()

    // Cargar un par de materiales iniciales
    biblioteca.agregarMaterial(Libro("1984", "George Orwell", 1949, "Distopía", 328))
    biblioteca.agregarMaterial(Revista("Muy Interesante", "Varios", 2022, "ISSN-9999", 55, 4))

    var opcion: Int
    do {
        println(
            """
        ==== MENÚ DE BIBLIOTECA ====
        1. Registrar nuevo usuario
        2. Ver materiales disponibles
        3. Prestar material
        4. Devolver material
        5. Ver préstamos de un usuario
        6. Salir
        """.trimIndent()
        )
        print("Seleccione una opción: ")
        opcion = readln().toIntOrNull() ?: 0

        when (opcion) {
            1 -> {
                print("Nombre: ")
                val nombre = readln()
                print("Apellido: ")
                val apellido = readln()
                print("Edad: ")
                val edad = readln().toIntOrNull() ?: 0
                biblioteca.agregarUsuario(Usuario(nombre, apellido, edad))
                println(" Usuario registrado correctamente.")
            }
            2 -> biblioteca.listarMateriales()
            3 -> {
                print("Nombre del usuario: ")
                val nom = readln()
                print("Apellido del usuario: ")
                val ape = readln()
                val usuario = biblioteca.buscarUsuario(nom, ape)

                if (usuario != null) {
                    biblioteca.listarMateriales()
                    print("Ingrese el título del material a prestar: ")
                    val titulo = readln()
                    val mat = biblioteca.buscarMaterial(titulo)
                    if (mat != null) biblioteca.prestar(mat, usuario)
                    else println(" Material no encontrado.")
                } else {
                    println(" Usuario no registrado.")
                }
            }
            4 -> {
                print("Nombre del usuario: ")
                val nom = readln()
                print("Apellido del usuario: ")
                val ape = readln()
                val usuario = biblioteca.buscarUsuario(nom, ape)

                if (usuario != null) {
                    biblioteca.listarPrestamos(usuario)
                    print("Ingrese el título del material a devolver: ")
                    val titulo = readln()
                    val prestados = biblioteca.buscarMaterial(titulo) // Ojo: ahora no está en disponibles
                    val material = usuario.let { u -> 
                        biblioteca.prestamos[u]?.find { it.titulo == titulo }
                    }
                    if (material != null) biblioteca.devolver(material, usuario)
                    else println("Ese material no está en préstamo.")
                } else {
                    println(" Usuario no registrado.")
                }
            }
            5 -> {
                print("Nombre del usuario: ")
                val nom = readln()
                print("Apellido del usuario: ")
                val ape = readln()
                val usuario = biblioteca.buscarUsuario(nom, ape)
                if (usuario != null) biblioteca.listarPrestamos(usuario)
                else println(" Usuario no encontrado.")
            }
            6 -> println(" Cerrando sistema de biblioteca...")
            else -> println(" Opción no válida, intente de nuevo.")
        }
    } while (opcion != 6)
}
