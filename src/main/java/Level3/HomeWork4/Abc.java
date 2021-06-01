package Level3.HomeWork4;
/*
1. Создать три потока, каждый из которых выводит определенную букву (A, B и C) 5 раз (порядок – ABСABСABС).
   Используйте wait/notify/notifyAll.
 */

public class Abc {
    private static volatile char c = 'A';
    private static final int repeat = 5;
    static Object obj = new Object();

    static class printABC extends Thread {
        private char first;
        private char second;

        public printABC(char firstLetter, char secondLetter) {
            this.first = firstLetter;
            this.second = secondLetter;
        }

        @Override
        public void run() {
            for (int i = 0; i < repeat; i++) {
                synchronized(obj) {
                    try {
                        while(c != first){
                            obj.wait();
                        }
                        System.out.print(first + " ");
                        c = second;
                        obj.notifyAll();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }


}
