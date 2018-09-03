(ns testing.gamewindow
  (:gen-class)
  (:require [seesaw.core :as sawcore]
            [seesaw.graphics :as sawgr]
            [testing.gary :as state])
 )


(def control-keys {java.awt.event.KeyEvent/VK_UP :up
                   java.awt.event.KeyEvent/VK_DOWN :down
                   java.awt.event.KeyEvent/VK_LEFT :left
                   java.awt.event.KeyEvent/VK_RIGHT :right
                   java.awt.event.KeyEvent/VK_SPACE :space
                   java.awt.event.KeyEvent/VK_ENTER :enter
                   java.awt.event.KeyEvent/VK_P :p
                  }
)

(defn start-window
  "initialize the game window"
  [title]
  (let [canvas (sawcore/canvas
                  :id :canvas
                  :background :black
                  :size [1000 :by 600]
                  :paint (fn [c g]
                           (state/draw-it g)))
        panel (sawcore/vertical-panel
                  :id :panel
                  :items [canvas])
        frame (sawcore/frame
                  :title title
                  :width 1000   
                  :height 600
                  :content panel
                  :resizable? false
                  :id :frame
                  :on-close :exit)
        ;delay 20 is around 50 fps
        main-loop (sawcore/timer (fn [e] (sawcore/repaint! frame)) :delay 20 :start? false)]



    ;run window loop
    (sawcore/native!)
    (sawcore/show! frame)
    (.start main-loop)))
