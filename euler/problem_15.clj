(ns euler.problem-15
  (:use [euler.util :only (kcomb)]))

(defn solve []
  "Returns the number of possible routes are there through a 20×20 grid."
  (let [dim 20]
    (kcomb (* dim 2) dim)))

(println (solve))