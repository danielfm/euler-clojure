(ns euler.problem-23
  (:use [euler.util :only (sum-proper-divisors)]))

(defn abundant? [n]
  "Returns whether n is abundant."
  (> (sum-proper-divisors n) n))

(defn sum-of-abundants? [eligible n]
  "Returns whether n can be written as the sum of two abundant numbers."
  (some #(contains? eligible (- n %)) eligible))

(defn solve []
  "Returns the sum of all the positive integers which cannot be written as the sum of two abundant numbers."
  (let [rng (range 1 28123) eligible (into #{} (filter abundant? rng))]
    (reduce + (filter (partial (complement sum-of-abundants?) eligible) rng))))

; Expected result: 4179871
(println (solve))
