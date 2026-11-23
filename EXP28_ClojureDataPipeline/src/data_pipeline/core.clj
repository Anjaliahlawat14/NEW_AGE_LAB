
(ns data-pipeline.core
  (:require [ring.adapter.jetty :as jetty]
            [ring.util.response :as response]
            [next.jdbc :as jdbc]
            [next.jdbc.result-set :as rs]
            [clojure.data.json :as json]))

(def students
  [{:id 1 :name "Anjali" :course "CSE" :marks 85}
   {:id 2 :name "Rahul" :course "IT" :marks 72}
   {:id 3 :name "Priya" :course "CSE" :marks 91}
   {:id 4 :name "Aman" :course "IT" :marks 45}])

(defn process-students []
  (let [processed
        (map
         (fn [student]
           (assoc student
                  :result (if (>= (:marks student) 50)
                            "Pass"
                            "Fail")))
         students)

        passed
        (filter
         #(= "Pass" (:result %))
         processed)

        total
        (reduce
         + 0
         (map :marks passed))

        average
        (if (seq passed)
          (/ total (count passed))
          0)]

    {:students (vec processed)
     :passed-students (vec passed)
     :total-marks total
     :average-marks average}))

(def db
  {:dbtype "sqlite"
   :dbname "data/students.db"})

(defn create-table []
  (try
    (jdbc/execute!
     db
     ["CREATE TABLE IF NOT EXISTS students (
        id INTEGER PRIMARY KEY,
        name TEXT NOT NULL,
        course TEXT NOT NULL,
        marks INTEGER NOT NULL
      )"])
    (println "Database table created successfully.")
    (catch Exception e
      (println "Database Error:" (.getMessage e)))))

(defn save-students []
  (try
    (doseq [student students]
      (jdbc/execute!
       db
       ["INSERT OR REPLACE INTO students
         (id, name, course, marks)
         VALUES (?, ?, ?, ?)"
        (:id student)
        (:name student)
        (:course student)
        (:marks student)]))
    (println "Students saved to database.")
    (catch Exception e
      (println "Insert Error:" (.getMessage e)))))

(defn get-students []
  (try
    (jdbc/execute!
     db
     ["SELECT * FROM students ORDER BY id"]
     {:builder-fn rs/as-unqualified-lower-maps})
    (catch Exception e
      (println "Read Error:" (.getMessage e))
      [])))

(defn json-response [data status]
  (-> (response/response (json/write-str data))
      (response/status status)
      (response/content-type "application/json")))

(defn app [request]
  (try
    (case (:uri request)
      "/" (response/response
           "Clojure Data Pipeline is running!")

      "/health"
      (json-response
       {:status "OK"
        :message "Application is running"}
       200)

      "/students"
      (json-response (get-students) 200)

      "/results"
      (json-response (process-students) 200)

      "/summary"
      (let [result (process-students)]
        (json-response
         {:total-marks (:total-marks result)
          :average-marks (:average-marks result)
          :passed-count (count (:passed-students result))
          :total-students (count (:students result))}
         200))

      (json-response
       {:error "Endpoint not found"}
       404))

    (catch Exception e
      (json-response
       {:error (.getMessage e)}
       500))))

(defn -main []
  (create-table)
  (save-students)
  (println "Starting Clojure Data Pipeline...")
  (println "Server running at http://localhost:3000")
  (jetty/run-jetty app
                   {:port 3000
                    :join? true}))
