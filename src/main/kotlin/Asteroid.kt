package com.adventofcode.util

fun main(args: Array<String>) {
    println("Hello World!")
    val asteroid = Asteroid(3, 2)

    println(asteroid)
}

class Asteroid(xCoordinate: Int, yCoordinate: Int) {
    val x: Int = xCoordinate
    val y: Int = yCoordinate
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Asteroid

        if (x != other.x) return false
        if (y != other.y) return false

        return true
    }

    override fun hashCode(): Int {
        var result = x
        result = 31 * result + y
        return result
    }

}