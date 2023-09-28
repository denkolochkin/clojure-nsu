(ns lab1_1)

(defn addSymbol [list alphabet]
  (if (empty? alphabet)
    ()
    (if (not= (first list) (first alphabet))
      (cons (conj list (first alphabet)) (addSymbol list (rest alphabet)))
      (addSymbol list (rest alphabet))
      )
    )
  )

(defn nextCombination [result alphabet]
  (if (empty? result)
    ()
    (concat (addSymbol (first result) alphabet) (nextCombination (rest result) alphabet))
    )
  )

(defn startLoop [result alphabet n]
  (if (= n 0)
    result
    (startLoop (nextCombination result alphabet) alphabet (dec n))
    )
  )

(defn getPermutations [alphabet n]
  (if (= n 0)
    ()
    (startLoop '(()) alphabet n)
    )
  )

(prn (getPermutations '() 2))
(prn (getPermutations '("a") 1))
(prn (getPermutations '("a" "b" "c") 2))
;(prn (getPermutations '("a" "b" "c" "d") 3))
;(prn (getPermutations '("a" "b") 100))
