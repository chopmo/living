(ns living.core)

;; (defn lcm [& xs]
;;   (let [result-or-nil (fn [map] (when (apply = (vals map))(first (vals map))))
;;         update-map (fn [map] (let [min-pair (first (sort-by last map))
;;                                 [min-key min-val] min-pair]
;;                             (assoc map min-key (+ min-val min-key))))]
;;    (loop [map (zipmap xs xs)]
;;      (or (lcm-result map) (recur (update-smallest map))))))

;; ;; Recursive
;; (defn pascal [n]
;;   (if (= 1 n)
;;     [1]
;;     (let [prev-list (pascal (dec n))
;;           partitions (partition 2 1 prev-list)
;;           updated-list (map (partial apply +) partitions)]
;;       (concat [1] updated-list [1]))))

;; ;; Iteration
;; (defn pascal [n]
;;   (loop [iteration 1
;;          list [1]]
;;     (if (= n iteration)
;;       list
;;       (let [partitions (partition 2 1 list)
;;             reduced-list (map (partial apply +) partitions)
;;             new-list (concat [1] reduced-list [1])]
;;         (recur (inc iteration) new-list)))))

;; (defn tree? [node]
;;   (boolean (or (nil? node)
;;        (if (and (coll? node) (= 3 (count node)))
;;          (let [[value left right] node]
;;            (and value (tree? left) (tree? right)))))))


(def balanced-tree? (fn [node]
   (letfn [(mirror [node]
             (if (nil? node) nil
                 (let [[value left right] node]
                   [value (mirror right) (mirror left)])))]

     (let [[value left right] node]
       (= left (mirror right))))))

(def flip
  (fn [f]
    (fn [& args]
      (apply f (reverse args)))))

(def rotate
  (fn [offset list]
    (let [list-size (count list)
          adjusted-offset (mod offset list-size)]
      (take list-size (drop adjusted-offset (cycle list))))))

(def rev-interleave
  (fn [s n]
    (let [list-size (/ (count s) n)
          lists (partition list-size s)]
      (map #() (range n)))))
