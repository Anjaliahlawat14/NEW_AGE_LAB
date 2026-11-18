
(println "---- FIRST COLLECTION ----")

(def numbers [1 2 3 4 5 6 7 8 9 10])

(println "Original Collection:" numbers)

(println "Squares:" (map #(* % %) numbers))

(println "Even Numbers:" (filter even? numbers))

(println "Sum:" (reduce + numbers))

(println "Take 5:" (take 5 numbers))

(println "Drop 5:" (drop 5 numbers))

(println "Threading Macro Result:"
         (->> numbers
              (filter even?)
              (map #(* % %))
              (take 3)))


(println "\n---- SECOND COLLECTION ----")

(def marks [45 60 75 30 90 55 80])

(println "Original Collection:" marks)

(println "Updated Marks:" (map #(+ % 5) marks))

(println "Marks Above 50:" (filter #(> % 50) marks))

(println "Total Marks:" (reduce + marks))

(println "Take 3:" (take 3 marks))

(println "Drop 3:" (drop 3 marks))

(println "Threading Macro Result:"
         (->> marks
              (filter #(> % 50))
              (map #(* % 2))
              (take 3)))
