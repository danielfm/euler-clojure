(ns euler.util
  (:use [clojure.contrib.def :only (defvar)]
	[clojure.contrib.math :only (sqrt)]))

(defn count-divisors [n]
  "Calculates the number of divisors of the natural number n."
  (let [x (long n)]
    (* 2 (count (filter #(zero? (rem x %)) (range 1 (sqrt x)))))))

(defn divisors [n]
  "Returns the divisors of the natural number n."
  (let [x (long n)]
    (filter #(zero? (rem x %)) (range 1 x))))

(defn sum-divisors [n]
  "Sums the divisors of the natural number n."
  (reduce + (divisors n)))

(defn prime? [n]
  "Checks whether the natural number n is prime."
  (.isProbablePrime (bigint n) 10))

(defn fact [n]
  "Calculates the factorial of n."
  (reduce * (range 2 (+ n 1))))

(defn k-comb [n k]
  "Returns the number of k-combinations from a set with n elements."
  (/ (fact n) (* (fact k) (fact (- n k)))))

(defn to-int [o]
  "Converts the object o to int."
  (Integer/parseInt (str o)))
