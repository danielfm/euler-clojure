(ns euler.problem-21)

(defn sum-of-divisors [n]
  "Returns the divisors of n."
  (reduce + (filter #(zero? (rem n %)) (range 1 n))))

(defn amicable [n]
  "Returns whether n is an amicable number."
  (let [a (sum-of-divisors n) b (sum-of-divisors a)]
    (and (not= n a) (= n b))))

(defn solve [n]
  "Evaluates the sum of all amicable numbers under n."
  (reduce + (filter amicable (range 1 n))))

; Expected result: 31626
(println (solve 10000))
