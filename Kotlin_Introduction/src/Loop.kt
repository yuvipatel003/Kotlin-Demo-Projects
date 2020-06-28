fun main() {
    var i = 0

    for (i in 1..10){
        println(i)
    }

    i = 0

    println()

    while(i < 10){
        println(i)
        i += 2
    }

    i = 0

    println()

    do {
        println(i)
        i += 20
    } while(i < 10)
}