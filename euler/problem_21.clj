(ns euler.problem-21
  (:use [euler.util :only (sum-proper-divisors)]))

(defn amicable [n]
  "Returns whether n is an amicable number."
  (let [a (sum-proper-divisors n) b (sum-proper-divisors a)]
    (and (not= n a) (= n b))))

(defn solve [n]
  "Evaluates the sum of all amicable numbers under n."
  (reduce + (filter amicable (range 1 n))))

; Expected result: 31626
(println (solve 10000))

