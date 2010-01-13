(ns euler.problem-27
  (:use [clojure.contrib.math :only (expt)]
	[clojure.contrib.lazy-seqs :only (primes)]
	[euler.util :only (prime? abs)]))

(defn prime-count [a b]
  "Counts the consecutive primes of a quadratic expression in terms of a and b."
  (loop [n 0]
    (if-not (prime? (+ (expt n 2) (* a n) b))
      n
      (recur (inc n)))))

(defn solve[]
  "Finds the product of the coefficients for the quadratic expression that"
  "produces the maximum number of primes for consecutive values of n."
  (let [c (for [b (take-while #(< % 1000) primes)
		a (filter odd? (range (- b) 1000))]
	    [(prime-count a b) (* a b)])
	s (apply hash-map (apply concat c))]
    (s (reduce max (keys s)))))

; Expected result: -59231
(println (solve))
