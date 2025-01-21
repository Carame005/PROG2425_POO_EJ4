import java.util.Locale

class Coche(
    var color : String,
    val marca : String,
    val modelo : String,
    var numeroDeCaballos : Int,
    var numeroDePuertas : Int,
    var matricula : String)
{
    var marcaMayuscula : String = marca
    var modeloMayuscula : String = modelo
    init {
        require(marca.isNotEmpty()){"La marca no puede estar en blanco"}
        require(modelo.isNotEmpty()){"El modelo no puede estar en blanco"}
        require(color.isNotEmpty()){"El color no puede estar vacio"}
        require(matricula.length == 7){"La matricula debe tener 7 carácteres"}
        marcaMayuscula = marcaMayuscula.replaceFirstChar {marca[0].uppercase()}
        modeloMayuscula = modeloMayuscula.replaceFirstChar {modelo[0].uppercase()}
        require(numeroDeCaballos >= 70 && numeroDeCaballos <= 700){"El numero de caballos debe estar entre 70 y 700"}
        require(numeroDePuertas <= 5 && numeroDePuertas >=3){"El numero de puertas debe estar entre 3 y 5"}
    }

    override fun toString(): String {
        return "El coche de color $color, es de marca $marcaMayuscula,modelo $modeloMayuscula, con un número de caballos de $numeroDeCaballos, $numeroDePuertas puertas y su matricula es $matricula"
    }

}


fun main(){
    val coche1 = Coche("Azul","opel","corsa",450,5,"LMX7850")
    println(coche1)

    try {
        val coche2 = Coche("","Opel","Corsa",450,5,"LMX7850")
        println(coche2)
    }catch (e: IllegalArgumentException){"ERROR ${e.message}"}

    try {
        val coche3 = Coche("Verde","","Corsa",450,5,"LMX7850")
        println(coche3)
    }catch (e: IllegalArgumentException){"ERROR ${e.message}"}

    try {
        val coche4 = Coche("Amarillo","Opel","",450,5,"LMX7850")
        println(coche4)
    }catch (e: IllegalArgumentException){"ERROR ${e.message}"}

    try {
        val coche5 = Coche("Rojo","Opel","Corsa",780,5,"LMX7850")
        println(coche5)
    }catch (e: IllegalArgumentException){"ERROR ${e.message}"}

    try {
        val coche6 = Coche("Negro","Opel","Corsa",450,80,"LMX7850")
        println(coche6)
    }catch (e: IllegalArgumentException){"ERROR ${e.message}"}

    try {
        val coche7 = Coche("Violeta","Opel","Corsa",450,5,"LMX24134137850")
        println(coche7)
    }catch (e: IllegalArgumentException){"ERROR ${e.message}"}
}