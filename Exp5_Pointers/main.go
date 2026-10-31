package main

import "fmt"

// Function
func changeValue(p *int) {
	*p = 50
}

func main() {

	a := 10
	p := &a

	fmt.Println("Original value:", a)
	fmt.Println("Address of a:", p)
	fmt.Println("Value using pointer:", *p)

	fmt.Println("\nBefore modification:", a)

	changeValue(p)

	fmt.Println("After modification:", a)

	type Student struct {
		name string
		age  int
	}

	s := new(Student)

	s.name = "Anjali"
	s.age = 21

	fmt.Println("\nStudent Details:")
	fmt.Println("Name:", s.name)
	fmt.Println("Age:", s.age)

	s.age = 22

	fmt.Println("Updated Age:", s.age)
}
