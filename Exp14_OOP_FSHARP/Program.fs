
open System

type Shape() =
    abstract member Area: unit -> float
    default this.Area() = 0.0

type Circle(radius: float) =
    inherit Shape()

    override this.Area() =
        Math.PI * radius * radius

type Rectangle(length: float, width: float) =
    inherit Shape()

    override this.Area() =
        length * width

let circle = Circle(5.0)
let rectangle = Rectangle(4.0, 6.0)

printfn "Circle Area: %.2f" (circle.Area())
printfn "Rectangle Area: %.2f" (rectangle.Area())

printfn "\nPolymorphism:"

let shapes: Shape list =
    [ circle :> Shape
      rectangle :> Shape ]

for shape in shapes do
    printfn "Area: %.2f" (shape.Area())
