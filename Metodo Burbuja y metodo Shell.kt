fun main() {
    // Definir las dimensiones del array tridimensional
    val años = 3
    val region = 4
    val Producto = 5
    val ArrayPlano = mutableListOf<Int>()

    // Crear un array tridimensional
    val ventas = Array(años) { Array(region) { IntArray(Producto) } }

    for (x in 0 until años) {
        for (y in 0 until region) {
            for (z in 0 until Producto) {
                ventas[x][y][z] = (1..50).random()
            }
        }
    }

    //Imprimir arreglo (Sin orden alguno)
    for (x in ventas.indices) {
        println("Año $x:")
        for (y in ventas[x].indices) {
            println("Region $y:")
            for (z in ventas[x][y].indices) {
                print("Producto $z: ${ventas[x][y][z]} | ")
            }
            println(" ")
        }
        println(" ")
    }

    val n = ventas.size
    val m = ventas[0].size
    val b = ventas[0][0].size

    val OrdenAniom = Array(años) { Array(region) { IntArray(Producto) } } //Array para modificar por metodo de burbuja
    val OrdenRegion = Array(region) { Array(años) { IntArray(Producto)} } //Array para modificar por metodo de Shell
    val OrdenProducto = Array(Producto) { Array(años) { IntArray(region)} } //Array para modificar por metodo Quicksort

    //Metodo de burbuja (Por año)
    for (i in 0 until n) {
        for (j in 0 until m) {
            for (k in 0 until b) {
                for (j2 in 0 until m) {
                    for (k2 in 0 until b) {
                        if (OrdenAniom[i][j][k] < OrdenAniom[i][j2][k2]) {
                            val temp = OrdenAniom[i][j][k]
                            OrdenAniom[i][j][k] = OrdenAniom[i][j2][k2]
                            OrdenAniom[i][j2][k2] = temp
                        }
                    }
                }
            }
        }
    }

    println("Ordenado por año (Mayor a menor):")
    for (x in ventas.indices) {
        println("Año $x:")
        for (y in (m - 1) downTo 0) {
            for (z in (b - 1) downTo 0) {
                print("${OrdenAniom[x][y][z]} |")
            }
            println(" ")
        }
        println(" ")
    }

    println("")
    println("Ordenado por año (Menor a mayor):")
    for (x in ventas.indices) {
        println("Año $x:")
        for (y in ventas[x].indices) {
            for (z in ventas[x][y].indices) {
                print("${OrdenAniom[x][y][z]} |")
            }
            println(" ")
        }
        println(" ")
    }

    //Metodo de shell (Region)
    val ventasRegion1 = IntArray(15) //Creando vectores unidimensionales por cada region
    val ventasRegion2 = IntArray(15)
    val ventasRegion3 = IntArray(15)
    val ventasRegion4 = IntArray(15)

    //adignando valores de la region 1, 2, 3 y 4
    var h=0
    for(i in ventas.indices){
        for(j in ventas[i][0].indices) {
            ventasRegion1[h] = ventas[i][0][j]
            ventasRegion2[h] = ventas[i][1][j]
            ventasRegion3[h] = ventas[i][2][j]
            ventasRegion4[h] = ventas[i][3][j]
            h++
        }
    }
    h=0

    print("Antes de ordenar 1: ")
    for(i in ventasRegion1.indices){
        print("${ventasRegion1[i]} |")
    }

    //OrdenandoCadaRegion
    Ordenshell(ventasRegion1)
    Ordenshell(ventasRegion2)
    Ordenshell(ventasRegion3)
    Ordenshell(ventasRegion4)
}

fun intercambio(x: Int, y: Int): Pair<Int, Int> {
    return Pair(y, x)
}

fun Ordenshell(A: IntArray){
    var n = A.size
    var salto = n/2
    while(salto>0){
        for(i in salto until n){
            var j = i-salto
            while(j>=0){
                var k = j+salto
                if(A[j]<=A[k]){
                    j= -1
                }else{
                    val resultado = intercambio(A[j],A[k])
                    A[j] = resultado.first
                    A[k] = resultado.second
                    j-=salto
                }
            }
        }
        salto /= 2
    }
}