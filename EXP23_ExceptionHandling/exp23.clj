
(println "---- EXCEPTION HANDLING IN CLOJURE ----")

(println "\n1. ARITHMETIC EXCEPTION")

(try
  (println "Result:" (/ 10 0))
  (catch ArithmeticException e
    (println "Error:" (ex-message e)))
  (finally
    (println "Arithmetic operation completed")))


(println "\n2. NULL POINTER EXCEPTION")

(try
  (let [value nil]
    (.toString value))
  (catch NullPointerException e
    (println "Error: Null value found"))
  (finally
    (println "Null check completed")))


(println "\n3. CUSTOM EXCEPTION")

(defn check-age [age]
  (if (< age 18)
    (throw (ex-info "Age must be 18 or above"
                    {:age age :error "Underage"}))
    (println "Eligible to vote")))

(try
  (check-age 16)
  (catch clojure.lang.ExceptionInfo e
    (println "Error:" (ex-message e))
    (println "Error Details:" (ex-data e)))
  (finally
    (println "Age verification completed")))


(println "\n4. GRACEFUL RECOVERY")

(try
  (check-age 15)
  (catch clojure.lang.ExceptionInfo e
    (println "Exception Message:" (ex-message e))
    (println "Exception Data:" (ex-data e))
    (println "Recovery: Please enter a valid age")))

(println "\nProgram completed successfully")
