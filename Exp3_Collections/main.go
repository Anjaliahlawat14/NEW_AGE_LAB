package main

import "fmt"

func main() {

	students := []string{"Rahul", "Anjali", "Aman"}

	fmt.Println("Original Slice:", students)

	students = append(students, "Priya")
	fmt.Println("After Adding:", students)

	students = append(students[:1], students[2:]...)
	fmt.Println("After Removing:", students)

	students[0] = "Rohit"
	fmt.Println("After Updating:", students)

	marks := map[string]int{
		"Go":     85,
		"Python": 90,
	}

	fmt.Println("\nOriginal Map:", marks)

	marks["Java"] = 80
	fmt.Println("After Inserting:", marks)

	delete(marks, "Python")
	fmt.Println("After Deleting:", marks)

	value, found := marks["Go"]

	if found {
		fmt.Println("Go Marks:", value)
	} else {
		fmt.Println("Subject not found")
	}
}
