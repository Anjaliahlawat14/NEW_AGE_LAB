
open System
open Microsoft.Data.Sqlite
open MongoDB.Bson
open MongoDB.Driver

printfn "\n===== SQLITE DATABASE ====="

let connection = new SqliteConnection("Data Source=students.db")
connection.Open()

let executeSql (sql: string) =
    use cmd = connection.CreateCommand()
    cmd.CommandText <- sql
    cmd.ExecuteNonQuery() |> ignore

let showSqlite () =
    use cmd = connection.CreateCommand()
    cmd.CommandText <- "SELECT * FROM Students"
    use reader = cmd.ExecuteReader()

    printfn "Student Records:"
    if reader.Read() then
        printfn "ID: %d, Name: %s, Age: %d"
            (reader.GetInt32(0))
            (reader.GetString(1))
            (reader.GetInt32(2))
    else
        printfn "No records found."

executeSql "CREATE TABLE IF NOT EXISTS Students
            (Id INTEGER PRIMARY KEY, Name TEXT, Age INTEGER)"

executeSql "DELETE FROM Students WHERE Id = 1"

executeSql "INSERT INTO Students VALUES (1, 'Anjali', 21)"
printfn "\nAfter CREATE:"
showSqlite()

printfn "\nAfter READ:"
showSqlite()

executeSql "UPDATE Students SET Age = 22 WHERE Id = 1"
printfn "\nAfter UPDATE:"
showSqlite()

executeSql "DELETE FROM Students WHERE Id = 1"
printfn "\nAfter DELETE:"
showSqlite()

connection.Close()

printfn "\n===== MONGODB DATABASE ====="

let client = new MongoClient("mongodb://localhost:27017")
let database = client.GetDatabase("Exp15DB")
let collection =
    database.GetCollection<BsonDocument>("Students")

let filter =
    Builders<BsonDocument>.Filter.Eq("_id", BsonInt32(1))

let showMongo () =
    let records =
        collection.Find(FilterDefinition<BsonDocument>.Empty).ToList()

    printfn "Student Records:"
    if records.Count > 0 then
        for student in records do
            printfn "%s" (student.ToJson())
    else
        printfn "No records found."

collection.DeleteOne(filter) |> ignore

let student = BsonDocument()
student.Add("_id", BsonInt32(1))
student.Add("Name", BsonString("Anjali"))
student.Add("Age", BsonInt32(21))

collection.InsertOne(student)

printfn "\nAfter CREATE:"
showMongo()

printfn "\nAfter READ:"
showMongo()

let update =
    Builders<BsonDocument>.Update.Set("Age", BsonInt32(22))

collection.UpdateOne(filter, update) |> ignore

printfn "\nAfter UPDATE:"
showMongo()

collection.DeleteOne(filter) |> ignore

printfn "\nAfter DELETE:"
showMongo()

printfn "\nCRUD Operations Completed Successfully!"
