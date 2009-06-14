(ns euler.problem-11
  (:use [clojure.contrib.duck-streams :only (read-lines)]
	[clojure.contrib.str-utils :only (re-split)]
	[euler.util :only (to-int)]))

(defn load-input [f]
  "Loads the problem input from the file f."
  (vec (for [l (read-lines f)]
	 (vec (map to-int (re-split #"\W" l))))))

(defn calculate-coords [o t n mx]
  "Uses the translation vector t to create n valid (x,y) coordinates starting from origin point o."
  (for [coords (take n (iterate #(map + t %) o))
	:while (every? #(< -1 % mx) coords)] coords))

(defn solve [f]
  "Returns the greatest product of four adjacent numbers in any direction (up, down, left, right, or diagonally) in the 20×20 grid."
  (let [grid (load-input f) s (count grid) rng (range s)]
    (apply max
	   (for [x rng y rng t [[1 1] [1 0] [-1 1]]]
	     (apply * (for [coord (calculate-coords [x y] t 4 s)]
			(reduce nth grid coord)))))))

(println (solve "euler/input/problem_11.txt"))