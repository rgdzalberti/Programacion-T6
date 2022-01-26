package DAM1_6_5_RGD

import java.util.logging.Level
import java.util.logging.LogManager

internal val l = LogManager.getLogManager().getLogger("").apply { level = Level.ALL }
internal fun i(tag: String, msg: String) {
    l.info("[$tag] - $msg")
}

interface GestorCatalogo {
    fun existeLibro(idLibro: String): Boolean
    fun infoLibro(idLibro: String): Map<String, Any>
}


fun main() {
    var portatil = "/home/edu/IdeaProjects/IESRA-DAM-Prog/ejercicios/src/main/kotlin/un5/eje5_4/Catalog.xml"
    //var casa = "/home/usuario/Documentos/workspace/IdeaProjects/IESRA-DAM/ejercicios/src/main/kotlin/un5/eje5_4/Catalog.xml"

    val gestorDeLibros = gestionLibros(CatalogoLibrosXML("C:\\Users\\usuarioT\\IdeaProjects\\Programacion-T6\\src\\main\\kotlin\\DAM1_6_5_RGD\\catalogo"))
    gestorDeLibros.preguntarPorUnLibro()
    gestorDeLibros.mostrarInfoDeUnLibro()

}

class gestionLibrosIU {

}

class gestionLibros(catalogo: GestorCatalogo)
{
    var cat: GestorCatalogo = catalogo

    fun preguntarPorUnLibro() {
        println("Introduzca un ID: ")
        var idLibro = readln()
        if (cat.existeLibro(idLibro))
            println("El libro $idLibro existe!")
        else
            println("El libro $idLibro NO existe!")
    }

    fun mostrarInfoDeUnLibro()
    {
        println("Introduzca un ID: ")
        var idLibro = readln()
        var infoLibro = cat.infoLibro(idLibro)
        if (!infoLibro.isEmpty())
            println("La información sobre es la siguiente\n$infoLibro")
        else
            println("No se encontró información sobre el libro")
    }

}