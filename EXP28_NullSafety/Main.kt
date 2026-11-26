
fun main() {

    println("----- NULLABLE AND NON-NULLABLE -----")

    var name: String = "Anjali"
    var nickname: String? = null

    println("Non-nullable name: $name")
    println("Nullable nickname: $nickname")

    nickname = "Anju"
    println("Updated nickname: $nickname")

    println("\n----- SAFE CALL OPERATOR -----")

    var city: String? = "Gurgaon"
    println("City length: ${city?.length}")

    city = null
    println("City length when null: ${city?.length}")

    println("\n----- ELVIS OPERATOR -----")

    var course: String? = null

    val result = course ?: "Course not available"
    println("Course: $result")

    course = "Data Science"
    val updatedResult = course ?: "Course not available"
    println("Updated Course: $updatedResult")

    println("\n----- NOT-NULL ASSERTION OPERATOR -----")

    var address: String? = null

    try {
        println("Address length: ${address!!.length}")
    } catch (e: NullPointerException) {
        println("Exception caught: ${e.message}")
        println("NullPointerException occurred because address is null.")
    }

    println("\nProgram executed successfully.")
}
