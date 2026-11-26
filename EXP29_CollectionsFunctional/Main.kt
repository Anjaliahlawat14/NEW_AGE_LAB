
data class Student(val name: String, val percentage: Double, val department: String)

fun main() {

    println("----- LIST -----")

    val readOnlyList = listOf("Java", "Kotlin", "Python")
    println("Read-only List: $readOnlyList")
    println("Contains Kotlin: ${readOnlyList.contains("Kotlin")}")
    println("Element at index 1: ${readOnlyList[1]}")

    val mutableList = mutableListOf("Java", "Kotlin", "Python")
    mutableList.add("Go")
    mutableList.remove("Java")
    println("Mutable List: $mutableList")
    println("Contains Go: ${mutableList.contains("Go")}")

    println("\n----- SET -----")

    val readOnlySet = setOf(10, 20, 30, 40)
    println("Read-only Set: $readOnlySet")
    println("Contains 20: ${readOnlySet.contains(20)}")

    val mutableSet = mutableSetOf(10, 20, 30)
    mutableSet.add(40)
    mutableSet.remove(10)
    println("Mutable Set: $mutableSet")
    println("Contains 40: ${mutableSet.contains(40)}")

    println("\n----- MAP -----")

    val readOnlyMap = mapOf(
        "Anjali" to 85,
        "Rahul" to 90,
        "Aman" to 80
    )
    println("Read-only Map: $readOnlyMap")
    println("Marks of Anjali: ${readOnlyMap["Anjali"]}")
    println("Contains Rahul: ${readOnlyMap.containsKey("Rahul")}")

    val mutableMap = mutableMapOf(
        "Anjali" to 85,
        "Rahul" to 90
    )
    mutableMap["Aman"] = 80
    mutableMap.remove("Rahul")
    println("Mutable Map: $mutableMap")
    println("Marks of Aman: ${mutableMap["Aman"]}")

    println("\n----- FUNCTIONAL TRANSFORMATIONS -----")

    val numbers = listOf(1, 2, 3, 4, 5)

    val mapped = numbers.map { it * 2 }
    println("Original List: $numbers")
    println("After map (multiply by 2): $mapped")

    val filtered = numbers.filter { it % 2 == 0 }
    println("After filter (even numbers): $filtered")

    val reduced = numbers.reduce { total, number -> total + number }
    println("After reduce (sum): $reduced")

    println("\n----- SORT STUDENTS -----")

    val students = listOf(
        Student("Anjali", 88.5, "CSE"),
        Student("Rahul", 75.0, "IT"),
        Student("Aman", 92.0, "CSE"),
        Student("Priya", 81.5, "IT")
    )

    val sortedStudents = students.sortedByDescending { it.percentage }

    println("Students sorted by percentage:")
    sortedStudents.forEach {
        println("${it.name} - ${it.percentage}%")
    }

    println("\n----- GROUP BY DEPARTMENT -----")

    val groupedStudents = students.groupBy { it.department }

    groupedStudents.forEach { (department, studentList) ->
        println("$department: ${studentList.map { it.name }}")
    }
}