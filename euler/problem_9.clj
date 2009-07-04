(ns euler.problem-9)

(defn solve []
  "There exists exactly one Pythagorean triplet for which a + b + c = 1000. Find the product abc."
  (first (for [a (range 1 500) b (range a 500) c [(- 1000 a b)]
	       :when (= (+ (* a a) (* b b)) (* c c))]
	   (* a b c))))

; Expected result: 31875000
(println (solve))
