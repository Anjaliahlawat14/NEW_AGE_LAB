
class Student(
    private var rollNo: Int,
    private var name: String,
    private var course: String,
    private var percentage: Double
) {

    fun updateDetails() {
        print("Enter Roll Number: ")
        rollNo = readln().toInt()

        print("Enter Name: ")
        name = readln()

        print("Enter Course: ")
        course = readln()

        print("Enter Percentage: ")
        percentage = readln().toDouble()
    }

    fun displayDetails() {
        println("\n----- Student Details -----")
        println("Roll Number: $rollNo")
        println("Name: $name")
        println("Course: $course")
        println("Percentage: $percentage%")
    }
}

fun main() {

    val student1 = Student(1, "Rahul", "CSE", 80.0)

    println("Enter First Student Details:")
    student1.updateDetails()
    student1.displayDetails()

    val student2 = Student(2, "Priya", "IT", 85.0)

    println("\nEnter Second Student Details:")
    student2.updateDetails()
    student2.displayDetails()
}
