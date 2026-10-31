package myutils

func Reverse(s string) string {
	result := ""
	for i := len(s) - 1; i >= 0; i-- {
		result += string(s[i])
	}
	return result
}

func CountVowels(s string) int {
	count := 0

	for _, ch := range s {
		if ch == 'a' || ch == 'e' || ch == 'i' ||
			ch == 'o' || ch == 'u' || ch == 'A' ||
			ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U' {
			count++
		}
	}

	return count
}

func Factorial(n int) int {
	fact := 1

	for i := 1; i <= n; i++ {
		fact = fact * i
	}

	return fact
}

func Power(base, exponent int) int {
	result := 1

	for i := 1; i <= exponent; i++ {
		result = result * base
	}

	return result
}
