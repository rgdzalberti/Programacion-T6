import un6.eje6_1.Alimentar
import un6.eje6_1.BackEnd
import un6.eje6_1.Donación
import un6.eje6_1.FrontEnd
import java.util.logging.Level
import java.util.logging.LogManager

val l = LogManager.getLogManager().getLogger("").apply { level = Level.OFF }

//Creo una interfaz de la que hederará las clases para que las subclases puedan comprobar que funcionan efectivamente sus variables.
interface Imprimir{ fun imprimir():String { return String.toString() } }

//Especialización
abstract class Ordenador(marca: String): Imprimir{
    val marca = marca
    override fun toString(): String { return "$marca" }
}

class Sobremesa(marca: String): Ordenador(marca){override fun imprimir(): String {return marca}}
class Portatil(marca: String): Ordenador(marca){override fun imprimir(): String {return marca}}

//Extensión
abstract class Familia(clase: String): Imprimir{
    val clase = clase
    override fun toString(): String { return "$clase" }
}
class FamiliaPadre(clase: String):Familia(clase){ override fun imprimir(): String {return clase}}
class FamiliaMadre(clase: String):Familia(clase){ override fun imprimir(): String {return clase}}

//Especificación
abstract class PaginaWeb(tipo: String): Imprimir{
    val tipo = tipo
    override fun toString(): String {
        return "$tipo"
    }
}
class FrontEnd(tipo: String):PaginaWeb(tipo){ override fun imprimir(): String {return tipo}}
class BackEnd(tipo: String):PaginaWeb(tipo){ override fun imprimir(): String {return tipo}}

//Construcción
abstract class ONG(localizacion: String): Imprimir{
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

    val PaginaWeb1: un6.eje6_1.PaginaWeb = FrontEnd("Blog")
    val PaginaWeb2: un6.eje6_1.PaginaWeb = BackEnd("Blog")
    //println(PaginaWeb1.imprimir()); println(PaginaWeb2.imprimir())

    val ONG1: un6.eje6_1.ONG = Donación("Chernobyl")
    val ONG2: un6.eje6_1.ONG = Alimentar("Chernobyl")
    //println(ONG1.imprimir()); println(ONG2.imprimir())

}


/*

 a) Pongo de clase abstracta a las superclases pues no se van a instanciar, son clases de las que solo se hereda.

 b)
 Una clase abstracta nos proporciona una clara base que puede usarse para proporcionar a otras clases una implementación.
 Una interfaz nos proporcioná ya una estructura clara dispuesta a ser modificada para el uso de cada clase especifica

 c) Con abstract fuerzo la herencia a las subclases

 */