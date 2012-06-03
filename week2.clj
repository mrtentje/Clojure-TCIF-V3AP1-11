(ns week2)

;question1
(reduce max [1 2 5 3 4])

;question2.1
; 12

;question2.2
((fn [x] (* x x)) 5)
(#(* % %) 5)

;question2.3
(filter #(< % 5) [1 6 5 2 3])

;question3
(defn question3
  ([x y ]
  (* x y))
  ([x y & others]
    (apply * x y others))  
  )

;question4.1
(defn question [lst] (first (reverse lst)))

;question4.2
(filter (fn [x] (string? x)) [1 6 "advanced" 2 "programming"])

;question4.3
(loop [c 0, n 10]
               (if (= c n) n
               (do
               (println c)
               (recur (+ c 2) n))))

;question5
(defn not-zero? 
     "Returns true if num is not zero, else false"
     {
      :inline(fn [x] `(not(. clojure.lang.Numbers (isZero ~x))))
      :added "1.0"}
     [x] (not (. clojure.lang.Numbers (isZero x))))

;question6.1
;Bij een partiële functie is één waarde van de argumenten al vooraf ingevuld, waardoor je deze
;niet meer in hoeft te vullen

;question6.2
(= '(3 4 5) (map (partial + 2) [1 2 3]))

;question6.3
(= "first second third" (let [a "second" b "third"] ((partial (fn [x y z] (str x " " y " " z)) "first") a b)))

;question6.4
;accepteerd meerde anonieme functies en geeft een compositie/samenstelling van deze functies terug
;de comp functie in Clojure wordt van rechts naar links aangeroepen

;question6.5
(= 8 (let [x 8 y 3] ((comp * max) x y)))
(= -8/3 (let [x 8 y 3] ((comp - /) x y)))
(= -5 (let [x 8 y 3] ((comp + - -) x y)))

;question7.1
;De functie complement neemt een functie als argument en levert een nieuwe functie op 
;die het tegenovergestelde teruggeeft van de functie die als argument is meegegeven.

;question7.2
(defn ends-with? [s c]
(.endsWith s (str c)))

(defn not-ends-with? [s c]
  ((complement ends-with?) s c))

;question8
(defn divisible-by-three? [x] (zero? (rem x 3)))

;question9
(defn max-except-first [lst] (apply max (next lst)))
  
;question10
 (defn average [a b] 
  (/ (+ a b) 2))

(defn abs[x] 
  (if (< x 0) (- x) x))

(defn make-good-enough? [n]
  (fn [guess] (< (abs (- n (* guess guess))) 0.001)))

(defn make-improver [n]
  (fn [guess] (average guess (/ n guess))))

(defn iterative-improve [x improve good?]
  (if (good? x) x
      (iterative-improve (improve x) improve good?)))

(defn square-root [n]
     (iterative-improve 1.0 (make-improver n) (make-good-enough? n)))