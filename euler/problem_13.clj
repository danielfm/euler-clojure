(ns euler.problem-13
  (:use [clojure.contrib.str-utils :only (re-split)]))

(defn load-input [f]
  "Loads the problem input from the file f."
  (map bigint (re-split #"\n" (slurp f))))

(defn solve [f]
  "Returns the first ten digits of the sum of the following one-hundred 50-digit
numbers."
  (apply str (take 10 (str (reduce + (load-input f))))))

; Expected result: 5537376230
(println (solve "euler/input/problem_13.txt"))
