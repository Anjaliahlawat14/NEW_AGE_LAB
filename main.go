package main

import (
	"fmt"
	"math"
)

func divide(a, b float64) (float64, error) {
	if b == 0 {
		return 0, fmt.Errorf("cannot divide by zero")
	}
	return a / b, nil
}

func squareRoot(n float64) (float64, error) {
	if n < 0 {
		return 0, fmt.Errorf("cannot find square root of negative number")
	}
	return math.Sqrt(n), nil
}

func checkInput(s string) error {
	if s == "" {
		return fmt.Errorf("input cannot be empty")
	}
	return nil
}

func main() {
	result, err := divide(10, 2)
	if err != nil {
		fmt.Println("Error:", err)
	} else {
		fmt.Println("Division:", result)
	}

	root, err := squareRoot(-9)
	if err != nil {
		fmt.Println("Error:", err)
	} else {
		fmt.Println("Square Root:", root)
	}

	err = checkInput("")
	if err != nil {
		fmt.Println("Error:", err)
	} else {
		fmt.Println("Input is valid")
	}
}
