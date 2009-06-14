(ns euler.problem-5
  (:use [clojure.contrib.math :only (lcm)]))

(defn solve []
  "Returns the smallest number that is evenly divisible by all of the numbers from 1 to 20?"
  (reduce lcm (range 1 21)))

(println (solve))
