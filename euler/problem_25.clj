(ns euler.problem-25
  (:use [clojure.contrib.lazy-seqs :only (fibs)]))

(defn solve [n]
  "Returns the first term in the Fibonacci sequence to contain 1000 digits."
  (let [terms (map vector (iterate inc 0) (fibs))]
    (first (first (drop-while (fn [[_ t]] (> n (count (str t)))) terms)))))

; Expected result: 4782
(println (solve 1000))
