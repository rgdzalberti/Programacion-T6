package un6.eje6_1

import java.util.logging.Level
import java.util.logging.LogManager

val l = LogManager.getLogManager().getLogger("").apply { level = Level.OFF }

//Especialización
open class Ordenador(marca: String){}
class Sobremesa(marca: String):Ordenador(marca){}
class Portatil(marca: String):Ordenador(marca){}

//Extensión
open class Familia(clase: String){
}
class FamiliaPadre(clase: String):Familia(clase){}
class FamiliaMadre(clase: String):Familia(clase){}

//Especificación
open class PaginaWeb(tipo: String){
}
class FrontEnd(tipo: String):PaginaWeb(tipo){}
class BackEnd(tipo: String):PaginaWeb(tipo){}

//Construcción
open class ONG(localizacion: String){
}
class Donación(localizacion: String):ONG(localizacion){}
class Alimentar(localizacion: String):ONG(localizacion){}

fun main() {

    Ordenador("Asus")
    Familia("Monoparental")
    PaginaWeb("Blog")
    ONG("Chernobyl")

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