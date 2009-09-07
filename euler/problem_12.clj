(ns euler.problem-12
  (:use [clojure.contrib.def :only (defvar)]
	[euler.util :only (count-divisors)]))

(defvar triangle-numbers 
  (lazy-seq (cons 1 (map + triangle-numbers (iterate inc 2))))
  "Returns a lazy infinite sequence of triangle numbers.")

(defn solve []
  "Returns the value of the first triangle number to have over five hundred divisors."
  (first (filter #(> (count-divisors %) 500) triangle-numbers)))

; Expected result: 76576500
(println (solve))
