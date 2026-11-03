
printf "Enter a number: "
let n = int (System.Console.ReadLine())

let rec isPrime n divisor =
    if n <= 1 then
        false
    elif divisor * divisor > n then
        true
    elif n % divisor = 0 then
        false
    else
        isPrime n (divisor + 1)

if isPrime n 2 then
    printfn "%d is a Prime Number" n
else
    printfn "%d is Not a Prime Number" n
