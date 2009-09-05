(ns euler.problem-10
  (:use [euler.util :only (prime?)]))

(defn solve []
  "Finds the sum of all the primes below two million."
  (reduce + (take-while #(< % (int 2e6)) (filter prime? (iterate inc 1)))))

; Expected result: 142913828922
(println (solve))
