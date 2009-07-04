(ns euler.problem-3
  (:use [euler.util :only (prime?)]
	[clojure.contrib.math :only (sqrt)]))

(defn solve []
  "Returns the largest prime factor of the number 600851475143."
  (let [n 600851475143]
    (loop [i (int (sqrt n))]
      (if (and (zero? (rem n i)) (prime? i))
	i
	(recur (dec i))))))

; Expected result: 6857
(println (solve))
