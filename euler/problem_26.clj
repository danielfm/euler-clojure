(ns euler.problem-26
  (:use [clojure.contrib.math :only (expt)]))

(defn mult-order [n]
  "Calculates the multiplicative order of the irrational number 1/n."
  (loop [i 1]
    (if (= (mod (expt 10 i) n) 1)
      i
      (recur (inc i)))))

(defn count-cycles [n]
  "Counts the number of decimal cycles of 1/n."
  (cond
    (= 1 n) 0
    (zero? (rem n 2)) (count-cycles (/ n 2))
    (zero? (rem n 5)) (count-cycles (/ n 5))
    :else (mult-order n)))

(defn solve []
  "Finds d < 1000 for which 1/d contains the longest recurring cycle in its
decimal fraction part."
  (let [n (range 2 1000)
	c (map count-cycles n)]
    ((zipmap c n) (apply max c))))

; Expected result: 983
(println (solve))
