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

(deftest test-flipping
  (let [__ flip]
    (testing "Higher order function to flip args"
      (is (= 3 ((__ nth) 2 [1 2 3 4 5])))
      (is (= true ((__ >) 7 8)))
      (is (= 4 ((__ quot) 2 8)))
      (is (= [1 2 3] ((__ take) [1 2 3 4 5] 3))))))


(deftest test-rotate
  (testing "Rotating a sequence in either direction"
    (let [__ rotate]
      (is (= (__ 2 [1 2 3 4 5]) '(3 4 5 1 2)))
      (is (= (__ -2 [1 2 3 4 5]) '(4 5 1 2 3)))
      (is (= (__ 6 [1 2 3 4 5]) '(2 3 4 5 1)))
      (is (= (__ 1 '(:a :b :c)) '(:b :c :a)))
      (is (= (__ -4 '(:a :b :c)) '(:c :a :b))))))

(deftest test-reverse-interleave
  (testing "Reversing the interleave process"
    (let [__ rev-interleave]
      (is (= (__ [1 2 3 4 5 6] 2) '((1 3 5) (2 4 6))))
      (is (= (__ (range 9) 3) '((0 3 6) (1 4 7) (2 5 8))))
      (is (= (__ (range 10) 5) '((0 5) (1 6) (2 7) (3 8) (4 9)))))))
