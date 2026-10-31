package main

import (
	"exp2/myutils"
	"fmt"
)

func main() {
	text := "Hello"

	fmt.Println("Original String:", text)
	fmt.Println("Reverse:", myutils.Reverse(text))
	fmt.Println("Vowels:", myutils.CountVowels(text))

	fmt.Println("Factorial of 5:", myutils.Factorial(5))
	fmt.Println("2 raised to 3:", myutils.Power(2, 3))
}
