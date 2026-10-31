package main

import "fmt"

type Person struct {
	Name   string
	Age    int
	Job    string
	Salary float64
}

func (p *Person) readData() {
	fmt.Println("Enter Name:")
	fmt.Scan(&p.Name)
	fmt.Println("Enter Age:")
	fmt.Scan(&p.Age)
	fmt.Println("Enter Job:")
	fmt.Scan(&p.Job)
	fmt.Println("Enter Salary:")
	fmt.Scan(&p.Salary)
}

func (p Person) displayData() {
	fmt.Println("\nPerson Details")
	fmt.Println("Name:", p.Name)
	fmt.Println("Age:", p.Age)
	fmt.Println("Job:", p.Job)
	fmt.Println("Salary:", p.Salary)
}

func main() {

	var p1, p2 Person

	fmt.Println("Enter details of Person 1")
	p1.readData()
	p1.displayData()

	fmt.Println("\nEnter details of Person 2")
	p2.readData()
	p2.displayData()
}
