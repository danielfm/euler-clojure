(ns euler.problem-10
  (:use [euler.util :only (prime?)]))

(defn solve []
  "Finds the sum of all the primes below two million."
  (reduce + (take-while #(< % 2000000) (filter prime? (iterate inc 1)))))

(println (solve))
