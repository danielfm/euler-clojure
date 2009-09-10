(ns euler.problem-24
  (:use [clojure.contrib.combinatorics :only (lex-permutations)]
	[euler.util :only (fact)]))

(defn permute [v a b]
  "Permutes the vector v using indexes a and b."
  (let [e (v b) sec (cons e (subvec v a b))]
    (vec (concat (subvec v 0 a) sec (subvec v (inc b))))))

(defn my-lex-permutations [digits n]
  "Returns the nth lexicographical permutation of seq digits."
  (let [s (vec (sort digits)) c (count s)]
    (loop [i 0 s s f (fact (dec c))]
      (if (>= i (dec c))
	s
	(let [ti (mod (int (/ n f)) (- c i)) j (inc i)]
	  (recur j (permute s i (+ i ti)) (/ f (- c j))))))))

(defn not-so-easy-solve [digits n]
  (apply str (my-lex-permutations digits (dec n))))

(defn easy-solve [digits n]
  (apply str (nth (lex-permutations digits) (dec n))))

; Expected result: 2783915460
(println (not-so-easy-solve (range 10) (int 1e6)))
(println (easy-solve (range 10) (int 1e6)))
