(println "---- LIST ----")

(def my-list '(10 20 30 40))

(println "Original List:" my-list)
(println "First Element:" (first my-list))
(println "Rest of List:" (rest my-list))

(def new-list (conj my-list 5))

(println "New List after conj:" new-list)
(println "Original List remains:" my-list)


(println "\n----- VECTOR -----")

(def my-vector [10 20 30 40])

(println "Original Vector:" my-vector)
(println "Element at index 2:" (get my-vector 2))
(println "Count:" (count my-vector))

(def new-vector (conj my-vector 50))

(println "New Vector after conj:" new-vector)
(println "Original Vector remains:" my-vector)


(println "\n----- MAP -----")

(def my-map {:name "Anjali" :age 21 :course "CSE"})

(println "Original Map:" my-map)
(println "Name:" (get my-map :name))

(def new-map (assoc my-map :city "Gurgaon"))

(println "New Map after assoc:" new-map)

(def updated-map (dissoc new-map :age))

(println "Map after dissoc:" updated-map)
(println "Original Map remains:" my-map)


(println "\n----- SET -----")

(def my-set #{10 20 30 40})

(println "Original Set:" my-set)
(println "Contains 20:" (contains? my-set 20))

(def new-set (conj my-set 50))

(println "New Set after conj:" new-set)

(def updated-set (disj new-set 10))

(println "Set after disj:" updated-set)
(println "Original Set remains:" my-set)
