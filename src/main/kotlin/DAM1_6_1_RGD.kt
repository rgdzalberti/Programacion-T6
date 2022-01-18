package un6.eje6_1
import java.util.logging.Level
import java.util.logging.LogManager

val l = LogManager.getLogManager().getLogger("").apply { level = Level.OFF }

//Creo una interfaz de la que hederará las clases para que las subclases puedan comprobar que funcionan efectivamente sus variables.
interface Imprimir{ fun imprimir():String { return String.toString() } }

//Especialización
open class Ordenador(marca: String): Imprimir{
    val marca = marca
    override fun toString(): String { return "$marca" }
}

class Sobremesa(marca: String): Ordenador(marca){override fun imprimir(): String {return marca}}
class Portatil(marca: String): Ordenador(marca){override fun imprimir(): String {return marca}}

//Extensión
open class Familia(clase: String): Imprimir{
    val clase = clase
    override fun toString(): String { return "$clase" }
}
class FamiliaPadre(clase: String):Familia(clase){ override fun imprimir(): String {return clase}}
class FamiliaMadre(clase: String):Familia(clase){ override fun imprimir(): String {return clase}}

//Especificación
open class PaginaWeb(tipo: String): Imprimir{
    val tipo = tipo
    override fun toString(): String {
        return "$tipo"
    }
}
class FrontEnd(tipo: String):PaginaWeb(tipo){ override fun imprimir(): String {return tipo}}
class BackEnd(tipo: String):PaginaWeb(tipo){ override fun imprimir(): String {return tipo}}

//Construcción
open class ONG(localizacion: String): Imprimir{
    val localizacion = localizacion
    override fun toString(): String {
        return "$localizacion"
    }
}
class Donación(localizacion: String):ONG(localizacion){override fun imprimir(): String {return localizacion}}
class Alimentar(localizacion: String):ONG(localizacion){override fun imprimir(): String {return localizacion}}

fun main(){

    val Ordenador1:Ordenador = Sobremesa("Asus")
    val Ordenador2:Ordenador = Portatil("Asus")
    //println(Ordenador1.imprimir()); println(Ordenador2.imprimir())

    val Clase1:Familia = FamiliaPadre("Monoparental")
    val Clase2:Familia = FamiliaMadre("Monomaternal")
    //println(Clase1.imprimir()); println(Clase2.imprimir())

    val PaginaWeb1:PaginaWeb = FrontEnd("Blog")
    val PaginaWeb2: PaginaWeb= BackEnd("Blog")
    //println(PaginaWeb1.imprimir()); println(PaginaWeb2.imprimir())

    val ONG1:ONG = Donación("Chernobyl")
    val ONG2: ONG = Alimentar("Chernobyl")
    //println(ONG1.imprimir()); println(ONG2.imprimir())

}

/*

c) Di que tipo de herencia es: (Especialización, Extensión, Especificación, Construcción).
Clase open any

d) ¿Quién es la superclase y subclase?
La superclase es el padre, de quien se hereda. La subclase es quien hereda, el hijo.

e) ¿Existe otra forma de implementarlo que no sea a través de la herencia?
Sí, por instancia.

f) Piensa y comenta qué ventajas aporta esta implementación de herencia, con respecto a otra.
-Código más límpio y claro
-Estructuras mecánicas (más fáciles de procesar)

 */