
printfn "HIGHER ORDER FUNCTIONS IN F#"

let list1 = [1; 2; 3; 4; 5]
let list2 = [6; 7; 8; 9; 10]

let square1 = List.map (fun x -> x * x) list1
let square2 = List.map (fun x -> x * x) list2

printfn "\nList.map:"
printfn "%A" square1
printfn "%A" square2

let even1 = List.filter (fun x -> x % 2 = 0) list1
let even2 = List.filter (fun x -> x % 2 = 0) list2

printfn "\nList.filter:"
printfn "%A" even1
printfn "%A" even2

let sum1 = List.fold (fun acc x -> acc + x) 0 list1
let sum2 = List.fold (fun acc x -> acc + x) 0 list2

printfn "\nList.fold:"
printfn "Sum of List 1 = %d" sum1
printfn "Sum of List 2 = %d" sum2


