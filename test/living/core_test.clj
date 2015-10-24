(ns living.core-test
  (:require [clojure.test :refer :all]
            [living.core :refer :all]))

(deftest test-lcj
  (testing "LCM function"
    (is (= (lcm 2 3) 6))
    (is (= (lcm 5 3 7) 105))
    (is (= (lcm 1/3 2/5) 2))
    (is (= (lcm 3/4 1/6) 3/2))
    (is (= (lcm 7 5/7 2 3/5) 210))))
