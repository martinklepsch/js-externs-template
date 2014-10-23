(ns leiningen.new.js-externs
  (:require [leiningen.new.templates :refer [renderer name-to-path ->files]]
            [leiningen.core.main :as main]))

(def render (renderer "js-externs"))

(defn js-externs
  "FIXME: write documentation"
  [name]
  (let [data {:name name
              :sanitized (name-to-path name)}]
    (main/info "Generating fresh 'lein new' js-externs project.")
    (->files data
             ["src/{{sanitized}}/PLACE_JS_LIBRARY_HERE"
              (render "src/PLACE_JS_LIBRARY_HERE" data)
              "src/{{sanitized}}/externs/PLACE_EXTERNS_HERE"
              (render "src/externs/PLACE_EXTERNS_HERE" data)])))
