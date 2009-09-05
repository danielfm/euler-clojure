(ns euler.problem-18-67
  (:use [clojure.contrib.duck-streams :only (read-lines)]
	[clojure.contrib.str-utils :only (re-split)]
	[euler.util :only (to-int)]))

(defn load-input [f]
  "Loads the problem input from the file f."
  (vec (for [l (read-lines f)]
    (vec (map to-int (re-split #"\W" l))))))

(defn roll-up [bottom up]
  "Reduces the two base rows to one keeping only the best options."
  (vec (for [i (range (count up))]
	 (+ (up i) (max (bottom i) (bottom (inc i)))))))

(defn solve [f]
  "Finds the maximum total from top to bottom of a given triangle."
  (let [triangle (load-input f)]
    (first (reduce roll-up (reverse triangle)))))

; Expected result: 1074
(println (solve "euler/input/problem_18.txt"))

; Expected result: 7273
(println (solve "euler/input/problem_67.txt"))
