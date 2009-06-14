(ns euler.problem-16
  (:use [clojure.contrib.math :only (expt)]
	[euler.util :only (to-int)]))

(defn solve []
  "Returns the sum of the digits of the number 2^1000."
  (reduce + (map to-int (str (expt 2 1000)))))

(println (solve))