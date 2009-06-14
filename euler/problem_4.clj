(ns euler.problem-4)

(defn palindrome? [n]
  "Returns whether the number n is palindrome."
  (let [s (str n)]
    (= s (apply str (reverse s)))))

(defn solve[]
  "Returns the largest palindrome made from the product of two 3-digit numbers."
  (apply max (filter palindrome? (for [a (range 100 1000) b (range a 1000)] (* a b)))))

(println (solve))