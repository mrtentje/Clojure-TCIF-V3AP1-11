(ns week3
 (:require [clojure.xml :as xml]))
;question1a
(= (list :aap :noot :mies) '(:aap :noot :mies))
(= '(1 2 3 4) (flatten '(1 2 (3 4))))
(= '(1 2 3 4) (conj '(3 4) 2 1))

;question1b
(defn reverselist [x] (reverse x))

;question1c
(= (list :a :b :c) '(:a :b :c))

;question1d
(= (list 1 2 3 4) (conj '(2 3 4) 1))	
(= (list 1 2 3 4) (conj '(3 4) 2 1))

;question2a
(= '(1 2 3 4) (conj [1 2] 3 4))
(= '(1 2 3 4) (into () '(4 3 2 1)))

;question2b
(= [:a :b :c] (list :a :b :c) (vec '(:a :b :c)) (vector :a :b :c))

;question2c
(= (vector 1 2 3 4) (conj [1 2 3] 4))	
(= (vector 1 2 3 4) (conj [1 2] 3 4))

;question3a
(zipmap [:first :second :thrid] [1 2 3])

;question3b
(apply hash-map (interleave [:first :second :third] [1 2 3]))

;question3c
(def tentamencijfers [{:naam "Piet" :cijfer 7} {:naam "Klaas" :cijfer 3}])
(assoc-in tentamencijfers [1 :cijfer] 10)

;question3d
(get-in(assoc-in tentamencijfers [1 :cijfer] 10) [1 :cijfer])

;question3e
(= 20 ((hash-map :a 10, :b 20, :c 30) :b))
(= 20 (:b {:a 10, :b 20, :c 30}))

;question3f
(= {:a 1, :b 2, :c 3} (conj {:a 1} {:b 2} [:c 3]))

;question3g
(fn [key map] (and (nil? (get map key)) (contains? map key)))

;question4a
(remove #{:a :d} #{:a :b :c :d})

;question4b
(set [1 1 2 3])

;question4c
(clojure.set/union #{1 2 3 4} #{5 6 7 8})

;question4d	
(= #{:a :b :c :d} (set '(:a :a :b :c :c :c :c :d :d)))	
(= #{:a :b :c :d} (clojure.set/union #{:a :b :c} #{:b :c :d}))

;question4e
(= #{1 2 3 4} (conj #{1 4 3} 2))

;question4f
(= ((fn [a b] (reduce #(if (contains? b %2) (conj %1 %2) %1) #{} a)) #{0 1 2 3} #{2 3 4 5}) #{2 3})	
(= ((fn [a b] (reduce #(if (contains? b %2) (conj %1 %2) %1) #{} a)) #{0 1 2} #{3 4 5}) #{})	
(= ((fn [a b] (reduce #(if (contains? b %2) (conj %1 %2) %1) #{} a)) #{:a :b :c :d} #{:c :e :a :f :d}) #{:a :c :d})

;question5a
(cons 5 [1 2 3 4])

;question5b
;(clojure.string/join ", " ["een" "twee" "drie"])

;question5c
(defn my-but-last [lst]
  (try 
    (nth lst (- (count lst) 2))  
    (catch IndexOutOfBoundsException e)))

;question5d
(defn my-no-double-values [x]
  (distinct x))

;question6a
(defn repeat-fifteen [x] (repeat 15 x))

;question6b
(def xml-doc (clojure.xml/parse (java.io.File. "tentamenresultaten.xml")))
(defn resultaat-name [resultaat] (first (:content (first (:content resultaat)))))
(defn resultaat-cijfer [resultaat] (first (:content (second (:content resultaat)))))
(do (for [elt (xml-seq xml-doc) :when (= :resultaat (:tag elt))] [(resultaat-name elt) (resultaat-cijfer elt)]))

;question6c
(defn divisible-by-three? [x] (zero? (rem x 3)))
(for [i (range 20) :when (divisible-by-three? i)] i)

;question6d
(defn divisible-by-three? [x] (zero? (rem x 3)))
(map (fn [x] (when (divisible-by-three? x) x)) (range 20))