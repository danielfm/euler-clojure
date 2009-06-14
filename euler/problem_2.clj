(ns euler.problem-2
  (:use [clojure.contrib.lazy-seqs :only (fibs)]))

(defn solve []
  "Finds the sum of all the even-valued terms in the Fibbonacci sequence which do not exceed four million."
  (reduce + (filter even? (take-while #(<= % 4000000) (fibs)))))

(println (solve))