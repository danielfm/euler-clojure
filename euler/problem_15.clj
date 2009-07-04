(ns euler.problem-15
  (:use [euler.util :only (k-comb)]))

(defn solve []
  "Returns the number of possible routes are there through a 20×20 grid."
  (let [dim 20]
    (k-comb (* dim 2) dim)))

; Expected result: 137846528820
(println (solve))
