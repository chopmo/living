(ns living.core)

(defn update-smallest [map]
  (let [[min-key min-val] (first (sort-by last map))]
    (assoc map min-key (+ min-val min-key))))

(defn lcm [& xs]
  (loop [map (zipmap xs xs)]
    (if (apply = (vals map))
      (first (vals map))
      (recur (update-smallest map)))))
