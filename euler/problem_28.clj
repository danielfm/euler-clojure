(ns euler.problem-28)

(defn sum-diagonals [n]
  "Sums the diagonals of the a nxn espiral."
  (if (= n 1) n
      (reduce + (take 4 (iterate #(- % (dec n)) (* n n))))))

(defn solve []
  "Returns the sum of the numbers on the diagonals in a 1001x1001 spiral."
  (reduce + (map sum-diagonals (range 1 1002 2))))

; Expected result: 669171001
(println (solve))
