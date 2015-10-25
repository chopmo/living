(ns living.core)

(defn lcm [& xs]
  (let [result-or-nil (fn [map] (when (apply = (vals map))(first (vals map))))
        update-map (fn [map] (let [min-pair (first (sort-by last map))
                                [min-key min-val] min-pair]
                            (assoc map min-key (+ min-val min-key))))]
   (loop [map (zipmap xs xs)]
     (or (lcm-result map) (recur (update-smallest map))))))
