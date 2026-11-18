
(println "---- JAVA STATIC METHODS ----")

(println "Absolute Value:" (Math/abs -50))
(println "Square Root:" (Math/sqrt 144))
(println "Current Time:" (System/currentTimeMillis))


(println "\n---- JAVA ARRAYLIST ----")

(def my-list (new java.util.ArrayList))

(.add my-list "Apple")
(.add my-list "Banana")
(.add my-list "Mango")

(println "ArrayList:" my-list)
(println "First Element:" (.get my-list 0))
(println "List Size:" (.size my-list))

(.remove my-list "Banana")

(println "After Removing Banana:" my-list)


(println "\n---- JAVA HASHMAP ----")

(def my-map (new java.util.HashMap))

(.put my-map "Name" "Anjali")
(.put my-map "Course" "CSE")
(.put my-map "Year" 4)

(println "HashMap:" my-map)
(println "Student Name:" (.get my-map "Name"))
(println "Map Size:" (.size my-map))

(.remove my-map "Year")

(println "After Removing Year:" my-map)


(println "\n---- COLLECTION CONVERSION ----")

(def clojure-vector [10 20 30 40])

(def java-list (java.util.ArrayList. clojure-vector))

(println "Clojure Vector:" clojure-vector)
(println "Java ArrayList:" java-list)

(def new-clojure-list (vec java-list))

(println "Converted Clojure Vector:" new-clojure-list)
