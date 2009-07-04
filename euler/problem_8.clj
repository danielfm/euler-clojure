(ns euler.problem-8
  (:use [euler.util :only (to-int)]))

(defn load-input [f]
  "Loads the problem input from the file f."
  (map to-int (filter #(not= \newline %) (slurp f))))

(defn solve [f]
  "Returns the greatest product of five consecutive digits in the 1000-digit number"
  (apply max (map #(reduce * %) (partition 5 1 (load-input f)))))

; Expected result: 40824
(println (solve "euler/input/problem_8.txt"))
