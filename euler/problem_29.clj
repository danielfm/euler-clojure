(ns euler.problem-29
  (:use [clojure.contrib.math :only (expt)]))

(defn aseq [first last]
  "Returns the sequence of distinct elements in the sequence a^b for
first <= a|b <= last."
  (into #{} (for [a (range first (inc last))
		  b (range first (inc last))] (expt a b))))

(defn solve []
  "Returns how many distinct terms in the sequence a^b for 2 <= a|b <= 100."
  (count (aseq 2 100)))

; Expected result: 9183
(println (solve))