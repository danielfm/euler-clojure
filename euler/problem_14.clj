(ns euler.problem-14)

;; Odd numbers tends to produce longer chains than even numbers

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
  "Returns the starting number, under one million, which produces the longest
chain."
  (loop [n 999999 m 1 lc 0]
    (let [c (collatz-count n)]
      (if (= n 1)
	m
	(if (> c lc)
	  (recur (- n 2) n c)
	  (recur (- n 2) m lc))))))

; Expected result: 837799
(println (solve))
