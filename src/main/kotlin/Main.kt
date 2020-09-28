fun sayHello(greeting:String, toGreet:String) = println("$greeting $toGreet")

fun main() {
    val things = mutableListOf("Kotlin", "programming", "comic books")
    val map = mapOf(1 to "a", 2 to "b", 3 to "c")
    map.forEach { (key, value) -> println("$key -> $value") }
    things.add("Star Trek")
    things.forEach { println(it) }
}