fun main(args: Array<String>) {
    println("Hello World!")
    val asteroid = Asteroids(3)
    println(asteroid)
}

class Asteroids(xcoordinate: Int) {
    var x: Int
    init {
        x = xcoordinate
    }
}