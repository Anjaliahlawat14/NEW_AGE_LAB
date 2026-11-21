
fun greet(name: String = "Student", message: String = "Welcome") {
    println("$message, $name!")
}

fun display(name: String, age: Int, city: String) {
    println("Name: $name")
    println("Age: $age")
    println("City: $city")
}

fun printNumbers(vararg numbers: Int) {
    println("Numbers:")
    for (n in numbers) {
        println(n)
    }
}

fun calculate(numbers: List<Int>, operation: (Int) -> Int) {
    val result = numbers.map(operation)
    println("Result: $result")
}

fun main() {
    println("Default Arguments:")
    greet()
    greet("Anjali", "Hello")

    println("\nNamed Arguments:")
    display(city = "Delhi", age = 21, name = "Anjali")

    println("\nVararg Function:")
    printNumbers(10, 20, 30, 40, 50)

    println("\nHigher-Order Function:")
    val numbers = listOf(1, 2, 3, 4, 5)
    calculate(numbers) { it * it }
}
