(ns euler.problem-1)

(defn multiple-of-any? [coll n]
  "Returns whether n is multiple of any number in coll."
  (some #(zero? (rem n %)) coll))

(defn solve []
  "Finds the sum of all the multiples of 3 or 5 below 1000."
  (reduce + (filter (partial multiple-of-any? [3 5]) (range 1000))))

(println (solve))
