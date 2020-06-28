fun main() {

    var A:Short = 1
    var B = 10
    var C = 100L // var C:Long = 100
    var D = 1000f // var D:Float = 1000
    var E = 10000.0
    var F = 'F'
    var G = "G"

    printDataType(A)
    printDataType(B)
    printDataType(C)
    printDataType(D)
    printDataType(E)
    printDataType(F)
    printDataType(G)

}

/**
 * print datatype of parameter
 */
fun<T> printDataType(x:T){

    when (x){
        is Short -> println(x.toString() + " is a Short")
        is Int -> println(x.toString() + " is an Int")
        is Long -> println(x.toString() + " is a Long")
        is Float -> println(x.toString() + " is a Float")
        is Double -> println(x.toString() + " is a Double")
        is Char -> println(x.toString() + " is a Char")
        is String -> println(x.toString() + " is a String")
        is Byte -> println(x.toString() + " is a Byte")
    }
}