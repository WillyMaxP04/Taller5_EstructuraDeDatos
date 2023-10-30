import java.util.*

data class Venta(val año: Int, val región: String, val categoría: String, val monto: Double)

fun main() {
    val ventas = mutableListOf<Venta>()
    val scanner = Scanner(System.`in`)
    while (true) {
        println("Ingrese el año (0 para salir): ")
        val año = scanner.nextInt()
        if (año == 0) {
            break
        }

        println("Ingrese la región: ")
        val región = scanner.next()

        println("Ingrese la categoría de productos: ")
        val categoría = scanner.next()

        println("Ingrese el monto de ventas: ")
        val monto = scanner.nextDouble()

        ventas.add(Venta(año, región, categoría, monto))
    }

    while (true) {
        println("Elija un análisis:")
        println("1. Mostrar las ventas totales en un año específico")
        println("2. Calcular el crecimiento de ventas en una región específica a lo largo de varios años")
        println("3. Identificar la categoría de productos más vendida en una región en un año específico")
        println("4. Ordenar productos por ventas")
        println("5. Salir")
        val opcion = scanner.nextInt()

        if (opcion == 5) {
            break
        }

        when (opcion) {
            1 -> {
                println("Ingrese el año para mostrar las ventas totales: ")
                val añoSeleccionado = scanner.nextInt()
                val ventasTotales = calcularVentasTotalesEnAño(ventas, añoSeleccionado)
                println("Las ventas totales en el año $añoSeleccionado son: $ventasTotales")
            }
            2 -> {
                println("Ingrese la región para calcular el crecimiento de ventas: ")
                val regiónSeleccionada = scanner.next()
                calcularCrecimientoDeVentasEnRegión(ventas, regiónSeleccionada)
            }
            3 -> {
                // Identificar la categoría de productos más vendida en una región en un año específico
                println("Ingrese el año: ")
                val añoSeleccionado2 = scanner.nextInt()
                println("Ingrese la región: ")
                val regiónSeleccionada2 = scanner.next()
                identificarCategoríaMásVendida(ventas, añoSeleccionado2, regiónSeleccionada2)
            }
            4 -> {
                // Ordenar productos por ventas
                println("¿Desea ordenar en orden ascendente o descendente? (asc/desc): ")
                val orden = scanner.next()
                val ascendente = orden == "asc"
                ordenarProductosPorVentas(ventas, ascendente)
                println("Productos ordenados por ventas:")
                ventas.forEach { venta ->
                    println("${venta.categoría}: ${venta.monto}")
                }
            }
            else -> println("Opción no válida.")
        }
    }

    scanner.close()
}

fun calcularVentasTotalesEnAño(ventas: List<Venta>, año: Int): Double {
    var ventasTotales = 0.0
    for (venta in ventas) {
        if (venta.año == año) {
            ventasTotales += venta.monto
        }
    }
    return ventasTotales
}

fun calcularCrecimientoDeVentasEnRegión(ventas: List<Venta>, región: String) {
    var ventasAnteriores = 0.0
    for (venta in ventas) {
        if (venta.región == región) {
            println("Año ${venta.año}: ${venta.monto}")
            if (ventasAnteriores > 0) {
                val crecimiento = (venta.monto - ventasAnteriores) / ventasAnteriores * 100
                println("Crecimiento: $crecimiento%")
            }
            ventasAnteriores = venta.monto
        }
    }
}

fun identificarCategoríaMásVendida(ventas: List<Venta>, año: Int, región: String) {
    var categoríaMásVendida: String? = null
    var ventasMáximas = 0.0
    for (venta in ventas) {
        if (venta.año == año && venta.región == región) {
            if (venta.monto > ventasMáximas) {
                categoríaMásVendida = venta.categoría
                ventasMáximas = venta.monto
            }
        }
    }
    if (categoríaMásVendida != null) {
        println("La categoría más vendida en $región en el año $año es: $categoríaMásVendida")
    } else {
        println("No se encontraron datos para esa región y año.")
    }
}

fun ordenarProductosPorVentas(ventas: MutableList<Venta>, ascending: Boolean) {
    ventas.sortBy { it.monto }
    if (!ascending) {
        ventas.reverse()
    }
}