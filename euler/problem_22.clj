(ns problem-22)

(defn load-input[f]
  "Loads the problem input from the file f."
  (map vector (iterate inc 1) (sort (re-seq #"\w+" (slurp f)))))

(defn score [[idx name]]
  "Returns the score for the given entry e."
  (* idx (apply + (map #(- (int %) 64) name))))

(defn solve [f]
  "Finds the total of all the name scores in the file f."
  (reduce + (map score (load-input f))))

; Expected result: 871198282
(println (solve "euler/input/problem_22.txt"))
