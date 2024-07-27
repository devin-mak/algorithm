package com.wheat.algorithm.base.dynamicprogramming;

/**
 * @author maij
 * @description:
 * @date 2024-06-07 16:32
 **/
public class Test {

    TransactionLock mockLock = new TransactionLock() {
        @Override
        public boolean lock(String id) {
            return false;
        }

        @Override
        public void unlock() {
            System.out.println("unlock");
        }
    };
}
