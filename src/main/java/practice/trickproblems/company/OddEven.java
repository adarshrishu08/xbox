package practice.trickproblems.company;

public class OddEven {

        public static volatile int successor = 1;
        public static volatile int predecessor = 0;

        public static void main(String[] args) throws InterruptedException {

            // T1 - T1, T1, T1, T1, T1
            // T2 - T2, T2, T2, T2, T2
            // T3 - T3, T3, T3, T3, T3


            // T1 - print event numbers - 0, 2, 4, 6, 8 ....
            // T2 - print odd numbers - 1, 3, 5, 7 ......
            // output - 0, 1, 2, 3, 4, 5, 6 ....


            // product consumer - using wait & notify - use array as your datastructure

            OddEven test = new OddEven();
            int numbersToPrint = 10;

            Thread evenThread = new Thread(() -> {
                synchronized (test) {
                    for (int i = 1; i <= numbersToPrint; i++) {
                        if (i % 2 == 0) {
                            if (successor > predecessor) {
                                try {
                                    test.wait();
                                } catch (InterruptedException ie) {
                                    ie.printStackTrace();
                                }
                            }
                            System.out.println("Even Number : " + i);
                            ++successor;
                            --predecessor;
                            System.out.println("EvenThread - " + "Successor : " + successor + " Predecessor :" + predecessor);
                            test.notify();
                        }
                    }
                }
            });
            Thread oddThread = new Thread(() -> {
                synchronized (test) {
                    for (int i = 1; i <= numbersToPrint; i++) {
                        if (i % 2 != 0) {
                            if (successor < predecessor) {
                                try {
                                    test.wait();
                                } catch (InterruptedException ie) {
                                    ie.printStackTrace();
                                }
                            }
                            System.out.println("Odd Number : " + i);
                            --successor;
                            ++predecessor;
                            System.out.println("OddThread - " + "Successor : " + successor + " Predecessor :" + predecessor);
                            test.notify();
                        }
                    }
                }
            });

            evenThread.start();
            oddThread.start();

//            evenThread.join();
//            oddThread.join();

        }






}