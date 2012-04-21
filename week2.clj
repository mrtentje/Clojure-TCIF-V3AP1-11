(ns week2)

;question1
(reduce max [1 2 5 3 4])

;question2.1
; 12

;question 2.2
((fn [x] (* x x)) 5)
(#(* % %) 5)

;question 2.3
(filter #(< % 5) [1 6 5 2 3])