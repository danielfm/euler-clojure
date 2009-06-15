(ns euler.problem-14
  (:use [clojure.contrib.lazy-seqs :only (primes)]))

; A smaller and beautiful solution takes ~1.2 min to run, but this
; one takes only ~15 sec

(defn collatz-count [n]
  "Returns the sequence count starting from the natural number n."
  (if (= n 1)
    n
    (+ 1
       (collatz-count (if (even? n)
			(/ n 2)
			(+ (* n 3) 1))))))

(def collatz-count (memoize collatz-count))

(defn solve []
  "Returns the starting number, under one million, which produces the longest chain."
  (loop [n (int 1e6) m 1 lc 0]
    (let [c (collatz-count n)]
      (if (= n 1)
	m
	(if (> c lc)
	  (recur (dec n) n c)
	  (recur (dec n) m lc))))))

(println (solve))
