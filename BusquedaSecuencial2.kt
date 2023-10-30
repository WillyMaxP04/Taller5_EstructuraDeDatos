//Este algoritmo de busqueda es el Busqueda Secuencial

//Este busqueda secuencial ya es en el caso en el que el usuario escriba los tres datos, el año, la región y el producto para realizar la busqueda

//Creo que este el que seria, pero igual ambos son busqueda secuencial entonces bien

fun busquedaArray2(arrayautilizar: Array<Array<Array<Pair<Any, Pair<String, String>>>>>, conjuntodatos: Triple<Int,String,String>): String {
    val (year,region,producto) = conjuntodatos
    if (year >= 0 && year<arrayautilizar.size){
        for (i in arrayautilizar[year].indices){
            val valor = arrayautilizar[year][i]
            for (j in valor.indices){
                if (valor[j].second.first == region && valor[j].second.second == producto){
                    return " El valor se encontró en la ubicación ($year,$i,$j)"
                }
            }
        }
    }
    return "No se encontró el array"
}

//Se decidió escoger este algoritmo de busqueda ya que al estar trabajando con un array tridimensional, es mejor pasar por cada dto existente
//y verificar que no esta para evitar algun fallo como que el dato si estaba pero al no usar un metodo indicado, pues no se encontró,
// y en ese caso la busqueda secuencial es indicado ya que es un metodo sencillo y flexible que se puede utilizar en muchoas estructuras de datos 
// como el array tridiomensional y es segura en que no falte verificar algun espacio.
