
data class Student(
    val name: String,
    val age: Int,
    val course: String?,
    val marks: Int?
)

fun Student.isPassed(): Boolean {
    return (marks ?: 0) >= 40
}

fun Student.displayDetails(): String {
    return "Name: $name, Course: ${course ?: "Not Registered"}, Marks: ${marks ?: "Not Available"}"
}

class CourseReport {
    private val details = mutableListOf<String>()

    fun title(text: String) {
        details.add("\n---- $text ----")
    }

    fun section(text: String) {
        details.add("\n$text")
    }

    fun add(text: String) {
        details.add(text)
    }

    fun generate(): String {
        return details.joinToString("\n")
    }
}

fun courseReport(block: CourseReport.() -> Unit): CourseReport {
    val report = CourseReport()
    report.block()
    return report
}

fun main() {

    val students = listOf(
        Student("Anjali", 21, "Kotlin", 85),
        Student("Dev", 22, "Java", 72),
        Student("Jigyasa", 20, "Kotlin", 91),
        Student("Shubham", 21, null, 35),
        Student("Bhuveeta", 22, "Java", null)
    )

    println("---- STUDENT DETAILS ----")

    students.forEach {
        println(it.displayDetails())
    }

    val names = students.map { it.name }
    println("\nStudent Names: $names")

    val passedStudents = students.filter { it.isPassed() }
    println("\nPassed Students:")
    passedStudents.forEach {
        println(it.name)
    }

    val totalMarks = students
        .mapNotNull { it.marks }
        .reduce { total, mark -> total + mark }

    println("\nTotal Marks: $totalMarks")

    val groupedStudents = students.groupBy {
        it.course ?: "Not Registered"
    }

    println("\nStudents Grouped by Course:")
    groupedStudents.forEach { (course, studentList) ->
        println("$course: ${studentList.map { it.name }}")
    }

    val report = courseReport {
        title("COURSE REGISTRATION REPORT")

        section("Total Students")
        add(students.size.toString())

        section("Passed Students")
        add(passedStudents.size.toString())

        section("Total Marks")
        add(totalMarks.toString())

        section("Course Groups")
        groupedStudents.forEach { (course, studentList) ->
            add("$course: ${studentList.size} students")
        }
    }

    println(report.generate())
}