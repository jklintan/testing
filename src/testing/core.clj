(ns testing.core
  (:require [testing.gamewindow :as shell])
  (:gen-class)
  (:use seesaw.core)
  (:use seesaw.font)
)

(defn -main
  [& args]
  (shell/start-window "Snailed it!")
  )

(def square [[1 1]
             [1 1]])

             