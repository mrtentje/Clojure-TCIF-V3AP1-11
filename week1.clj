(ns week1)

;question2
;2 3 4 5


(def question3 (/ 3 4.0))

(def question4 (- 465 (+ (/ (* 774 3) 3) 774)))

;question5
  (def d1(java.util.Date.))
	(def d2(java.util.Date.))
	(if (= d1 d2) "de data zijn gelijk" "de data zijn niet gelijk")  
  


;question 6.1
;Vergelijkbaar met een switch case statement maar hierbij kunnen logische condities geëvalueerd worden.  
  

;question 6.2
    (cond 
     (= 1 2) "een is gelijk aan twee"
     (< 1 2) "een is kleiner dan twee"
     :else "geen van beide")
  

(comment question 7)
  (do (print "(- 465 (+ (/ (* 774 3) 3) 774))") (- 465 (+ (/ (* 774 3) 3) 774)))  


;question8
    (= 9 (let [x 8 y 1] (+ x y)))
    (= 3 (let [y 1 z 2] (+ y z)))
    (= 2 (let [z 2] z))
  

(defn question9 [name]
           (.replaceAll "Hello, <name>" "<name>" name))

;question10
;[x 7 y 3 z 1]
  