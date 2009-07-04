(ns euler.problem-7
  (:use [clojure.contrib.lazy-seqs :only (primes)]))

(defn solve[]
  "Returns the 1001st prime number."
  (nth primes 10000))

; Expected result: 104743
(println (solve))
