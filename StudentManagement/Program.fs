
open System
open Microsoft.Data.Sqlite

type Student = {
    Id: int
    Name: string
    Marks: int
}

let students = [
    { Id = 1; Name = "Anjali"; Marks = 87 }
    { Id = 2; Name = "Dev"; Marks = 35 }
    { Id = 3; Name = "Jigyasa"; Marks = 62 }
]

let checkResult marks =
    match marks with
    | m when m >= 40 -> "Pass"
    | _ -> "Fail"

printfn "Student Names:"
students
|> List.map (fun s -> s.Name)
|> List.iter (printfn "%s")

printfn "\nPassed Students:"
students
|> List.filter (fun s -> s.Marks >= 40)
|> List.iter (fun s -> printfn "%s" s.Name)

printfn "\nResults:"
students
|> List.iter (fun s ->
    printfn "%s : %s" s.Name (checkResult s.Marks))

let showStudents = async {
    let! result = async {
        return students |> List.map (fun s -> s.Name)
    }
    printfn "\nAsync Student List:"
    result |> List.iter (printfn "%s")
}

Async.RunSynchronously showStudents

let connection = new SqliteConnection("Data Source=college.db")
connection.Open()

let execute sql =
    use cmd = connection.CreateCommand()
    cmd.CommandText <- sql
    cmd.ExecuteNonQuery() |> ignore

execute "CREATE TABLE IF NOT EXISTS Students
         (Id INTEGER PRIMARY KEY, Name TEXT, Marks INTEGER)"

execute "DELETE FROM Students WHERE Id = 1"

execute "INSERT INTO Students VALUES (1, 'Anjali', 87)"
printfn "\nAfter Insert:"

let readData () =
    use cmd = connection.CreateCommand()
    cmd.CommandText <- "SELECT * FROM Students"
    use reader = cmd.ExecuteReader()

    while reader.Read() do
        printfn "%d %s %d"
            (reader.GetInt32(0))
            (reader.GetString(1))
            (reader.GetInt32(2))

readData()

printfn "\nAfter Read:"
readData()

execute "UPDATE Students SET Marks = 90 WHERE Id = 1"
printfn "\nAfter Update:"
readData()

execute "DELETE FROM Students WHERE Id = 1"
printfn "\nAfter Delete:"
readData()

connection.Close()

printfn "\nProgram completed successfully!"
