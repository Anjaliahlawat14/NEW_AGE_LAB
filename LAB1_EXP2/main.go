package main

import "fmt"

func main() {

	var a, b int
	var x, y float64
	var err error

	// Integer input validation
	for {
		fmt.Print("Enter two integers: ")
		_, err = fmt.Scan(&a, &b)

		if err == nil && a >= -1000 && a <= 1000 && b >= -1000 && b <= 1000 {
			break
		}

		fmt.Println("Invalid input! Enter numbers between -1000 and 1000.")
	}

	fmt.Println("Integer Addition:", a+b)
	fmt.Println("Integer Subtraction:", a-b)
	fmt.Println("Integer Multiplication:", a*b)

	// Float input validation
	for {
		fmt.Print("\nEnter two decimal numbers: ")
		_, err = fmt.Scan(&x, &y)

		if err == nil && x >= -1000 && x <= 1000 && y >= -1000 && y <= 1000 {
			break
		}

		fmt.Println("Invalid input! Enter valid decimal numbers between -1000 and 1000.")
	}

	fmt.Println("Float Addition:", x+y)
	fmt.Println("Float Subtraction:", x-y)
	fmt.Println("Float Multiplication:", x*y)
}
