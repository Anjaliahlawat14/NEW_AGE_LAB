open System
open System.Text.RegularExpressions

let checkPalindrome (str: string) =
    let reversed = String(Array.rev (str.ToCharArray()))

    printfn "Original String: %s" str
    printfn "Reversed String: %s" reversed

    if str = reversed then
        printfn "It is a Palindrome"
    else
        printfn "It is not a Palindrome"

let transformString (str: string) =
    if Regex.IsMatch(str, "^[a-zA-Z]+$") then
        str.ToUpper()
    elif Regex.IsMatch(str, "^[0-9]+$") then
        str + str
    else
        str

let checkEmail (email: string) =
    if Regex.IsMatch(email, "^[^@\s]+@[^@\s]+\.[^@\s]+$") then
        printfn "%s is a valid email" email
    else
        printfn "%s is an invalid email" email

printfn "PALINDROME CHECK"
checkPalindrome "madam"
checkPalindrome "hello"
checkPalindrome "level"

printfn "\nSTRING TRANSFORMATION"
printfn "hello -> %s" (transformString "hello")
printfn "123 -> %s" (transformString "123")
printfn "hello123 -> %s" (transformString "hello123")

printfn "\nEMAIL VALIDATION"
checkEmail "abc@gmail.com"
checkEmail "student@yahoo.com"
checkEmail "abcgmail.com"