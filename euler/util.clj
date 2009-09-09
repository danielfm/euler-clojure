(ns euler.util
  (:use [clojure.contrib.def :only (defvar)]
	[clojure.contrib.math :only (sqrt)]))
 
(defn count-proper-divisors [n]
  "Counts the proper divisors of the natural number n."
  (let [x (long n)]
    (inc (* 2 (count (filter #(zero? (rem x %)) (range 2 (sqrt x))))))))

(defn proper-divisors [n]
  "Returns the proper divisors of the natural number n."
  (let [x (long n)]
    (cons 1 (filter #(zero? (rem x %)) (range 2 x)))))

(defn sum-proper-divisors [n]
  "Sums the proper divisors of the natural number n."
  (let [limit (sqrt n)]
    (loop [i 2
	   sum 1]
      (cond
	(= i limit) (+ i sum)
	(> i limit) sum
	(zero? (rem n i)) (recur (inc i) (+ sum i (/ n i)))
	true              (recur (inc i) sum)))))

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
