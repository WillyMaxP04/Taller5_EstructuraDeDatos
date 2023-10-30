//Este algoritmo de busqueda es el Busqueda Secuencial

// Esta busqueda secuencia es por si el usuario solo da un dato a buscar

fun busquedaArray(arrayautilizar: Array<Array<Array<Pair<Any, Pair<Any, String>>>>>, datoabuscar: Any): String {
    for (Year in arrayautilizar.indices) {
        for (Region in arrayautilizar[Year].indices) {
            for (Producto in arrayautilizar[Year][Region].indices) {
                if (arrayautilizar[Year][Region][Producto].first == datoabuscar) {
                    return "El valor se encontró en la ubicación ($Year,$Region,$Producto) "
                }
            }
        }
    }
    return "No se encontró el dato en la base de datos"
}

//Se decidió escoger este algoritmo de busqueda ya que al estar trabajando con un array tridimensional, es mejor pasar por cada dto existente
//y verificar que no esta para evitar algun fallo como que el dato si estaba pero al no usar un metodo indicado, pues no se encontró,
// y en ese caso la busqueda secuencial es indicado ya que es un metodo sencillo y flexible que se puede utilizar en muchoas estructuras de datos
// como el array tridiomensional y es segura en que no falte verificar algun espacio.