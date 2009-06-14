(ns euler.problem-20
  (:use [euler.util :only (fact to-int)]))

(defn solve[]
  "Find the sum of digits in 100!"
  (reduce + (map to-int (str (fact 100)))))

(println (solve))