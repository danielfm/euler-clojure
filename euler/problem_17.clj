(ns euler.problem-17
  (:use [clojure.contrib.def :only (defvar)]))

(defvar one-to-nineteen
  ["" "one" "two" "three" "four" "five" "six" "seven" "eight" "nine" "ten"
   "eleven" "twelve" "thirteen" "fourteen" "fifteen" "sixteen" "seventeen"
   "eighteen" "nineteen"]
  "Cardinal numbers between 1 and 19.")

(defvar twenty-to-ninety
  ["twenty" "thirty" "forty" "fifty" "sixty" "seventy" "eighty" "ninety"]
  "Tens.")

(defn n-in-words [n]
  "Returns a description in words of the natural number n (between 1 and 1000)."
  (cond
   (< n 20) (nth one-to-nineteen n)
   (< n 100) (str (nth twenty-to-ninety (- (quot n 10) 2))
		  (n-in-words (rem n 10)))
   (< n 1000) (str (n-in-words (quot n 100)) "hundred"
		   (if (zero? (rem n 100)) ""
		       (str "and" (n-in-words (rem n 100)))))
   (= n 1000) "onethousand"))

(defn solve []
  "Returns the number of letters used to write in words all the numbers from 1 to 1000."
  (reduce + (map count (map n-in-words (range 1 1001)))))

; Expected result: 21124
(println (solve))
