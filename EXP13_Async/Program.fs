
open System

let task1 = async {
    printfn "Task 1 Started"
    do! Async.Sleep(2000)
    printfn "Task 1 Completed"
    return "Result of Task 1"
}

let task2 = async {
    printfn "Task 2 Started"
    do! Async.Sleep(1000)
    printfn "Task 2 Completed"
    return "Result of Task 2"
}

let task3 = async {
    printfn "Task 3 Started"
    do! Async.Sleep(1500)
    printfn "Task 3 Completed"
    return "Result of Task 3"
}

let tasks = [| task1; task2; task3 |]

printfn "Starting parallel tasks..."

let results =
    tasks
    |> Async.Parallel
    |> Async.RunSynchronously

printfn "All tasks completed."

for result in results do
    printfn "%s" result
