(ns week4)

;question1a
(defn sumTo
   ([n] (if (= n 0) n
   (sumTo n 0)))
   ([n total]
   (if (= n 0) total
   (recur (dec n) (+ n total)))))

;question1b
(defn times-called
  ([f start-val limit]
    (times-called f start-val limit 0)
    )
  ([f current-val limit iter]
    (if (>= current-val limit) (dec iter)
      )
    )
  )

;question2a
(def books-atom (atom ()))

(defn get-book [title]
  (filter #(= (:title %) title) @books-atom)
)

(defn insert-book [book]
  (if (= () (get-book (:title book)))
    (do (swap! books-atom conj book)
    book)
    (println "Insert-book: already a book with same title")
  )
)

(defn delete-book [title]
  (let [newAtom (filter #(not= (:title %) title) @books-atom)]
    (reset! books-atom newAtom)
   )
)

(defn update-book [title book]
  (if (not= () (get-book title))
    (do (delete-book title)
    (insert-book book))
  )
 )

;question2b
(def stopwatch (atom {:time nil}))

(defn start! []
  (if (not= (:time @stopwatch) nil)
    "Stopwatch already started"
    (do (swap! stopwatch assoc :time (. java.lang.System (nanoTime)))
      "Stopwatch started")))

(defn stop! []
(if (= (:time @stopwatch) nil)
  "start stopwatch first"
  (let [elapsed (format "%.3f" (/ (- (. System (nanoTime)) (:time @stopwatch)) 1000000000.00))]
      (do
	      (swap! stopwatch assoc :time nil)
	      (str elapsed " seconds passed since start")))))

;question2c
;Deze functie is wel een hogere order functie omdat hij de parameter “f” gebruiken als een functie in het volgende blok code:
;(apply f args)

;question3
(defmacro my-for [name start end & exprs]
 (if (>= start end)
     `(for [~name (range ~start ~end)] [~@exprs]))
  `(for [~name (reverse (range ~end ~start))] [~@exprs]))





  