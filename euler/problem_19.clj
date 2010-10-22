(ns euler.problem-19
  (:import (java.util Calendar)))

(defn new-calendar [year month date]
  "Creates a new Calendar object and set its date."
  (doto (Calendar/getInstance)
    (.set year (dec month) date 0 0 0)))

(defn inc-month [cal]
  "Returns a new Calendar with the month incremented."
  (doto (.clone cal)
    (.add Calendar/MONTH 1)))

(defn first-of-month [year]
  "Returns a lazy seq containing the first of each month starting in year."
  (iterate inc-month (new-calendar year 1 1)))

(defn solve [from-year to-year]
  "Finds how many Sundays fell on the first of the month during the twentieth
century."
  (let [date-seq (first-of-month from-year)]
    (count (filter #(= Calendar/SUNDAY (.get % Calendar/DAY_OF_WEEK))
		   (take-while #(< (.get % Calendar/YEAR) to-year) date-seq)))))

; Expected result: 171
(println (solve 1901 2001))
