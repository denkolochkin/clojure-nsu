(ns lab1_2)

(defn addSymbol [combination alphabet]
  ((fn [symbol nextCombination]
     (if (empty? symbol)
       nextCombination
       (if (not= (first combination) (first symbol))
         (recur  (rest symbol) (cons (conj combination (first symbol)) nextCombination) )
         (recur  (rest symbol) nextCombination)
         )
       )
     ) alphabet (list))
  )

(defn nextCombination [result alphabet]
  ((fn [combination nextCombination]
     (if (empty? combination)
       nextCombination
       (recur (rest combination) (concat nextCombination (addSymbol (first combination) alphabet))))) result (list))
  )


(defn startLoop [result alphabet n]
  (if (= n 0)
    result
    (recur (nextCombination result alphabet) alphabet (dec n))))


(defn getPermutations [symbols n]
  (if (not= n 0)
    (startLoop '(()) symbols n)
    ()
    ))

(prn (getPermutations '() 2))
(prn (getPermutations '("a") 1))
(prn (getPermutations '("a" "b" "c") 2))
;(prn (getPermutations '("a" "b" "c" "d") 3))
;(prn (getPermutations '("a" "b") 100))
