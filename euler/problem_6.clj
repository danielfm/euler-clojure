(ns euler.problem-6
  (:use [clojure.contrib.math :only (expt)]))

(defn sum-of-squares [coll]
  "Returns the sum of the squares of the numbers in coll."
  (reduce + (map #(expt % 2) coll)))

(defn square-of-the-sum [coll]
  "Returns the square of the sum of the numbers in coll."
  (expt (reduce + coll) 2))

(defn solve []
  "Returns the difference between the sum of the squares of the first one
hundred natural numbers and the square of the sum."
  (let [coll (range 1 101)]
    (- (square-of-the-sum coll) (sum-of-squares coll))))

; Expected result: 25164150
(println (solve))
