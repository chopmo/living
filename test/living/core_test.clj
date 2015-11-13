(ns living.core-test
  (:require [clojure.test :refer :all]
            [living.core :refer :all]))

;; (deftest test-lcj
;;   (testing "LCM function"
;;     (is (= (lcm 2 3) 6))
;;     (is (= (lcm 5 3 7) 105))
;;     (is (= (lcm 1/3 2/5) 2))
;;     (is (= (lcm 3/4 1/6) 3/2))
;;     (is (= (lcm 7 5/7 2 3/5) 210))))

;; (deftest test-tree?
;;   (testing "Tree predicate"
;;     (is (= (tree? '(:a (:b nil nil) nil)) ))))

(deftest test-balanced-tree?
  (testing "Balanced tree predicate"
    (let [__ balanced-tree?]
      (is (= (__ '(:a (:b nil nil) (:b nil nil))) true))
      (is (= (__ '(:a (:b nil nil) nil)) false))
      (is (= (__ '(:a (:b nil nil) (:c nil nil))) false))
      (is (= (__ [1
                  [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]]
                  [2 [3 nil [4 [6 nil nil] [5 nil nil]]] nil]]) true))
      (is (= (__ [1 [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]]
                  [2 [3 nil [4 [5 nil nil] [6 nil nil]]] nil]]) false))

      (is (= (__ [1 [2 nil [3 [4 [5 nil nil] [6 nil nil]] ]]
                  [2 [3 nil [4 [6 nil nil] nil]] nil]]) false)))))

;; (deftest test-flipping
;;   (let [__ flip]
;;     (testing "Higher order function to flip args"
;;       (is (= 3 ((__ nth) 2 [1 2 3 4 5])))
;;       (is (= true ((__ >) 7 8)))
;;       (is (= 4 ((__ quot) 2 8)))
;;       (is (= [1 2 3] ((__ take) [1 2 3 4 5] 3))))))
