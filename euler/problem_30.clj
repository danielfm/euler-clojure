(ns euler.problem-30
  (:use [euler.util :only (to-int)]
	[clojure.contrib.math :only (expt)]))

(defn expt-digits? [p n]
  "Returns wether the number n can be written as the sum of p powers of their
digits."
  (when (> n 1)
    (let [d (map to-int (str n))]
      (= n (apply + (map #(expt % p) d))))))

(defn solve []
  "Returns the sum of all the numbers that can be written as the sum of fifth
powers of their digits."
  (apply + (filter (partial expt-digits? 5) (range 999999))))

; Expected result: 443839
(println (solve))
