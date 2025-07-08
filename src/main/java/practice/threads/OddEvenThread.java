package practice.threads;

public class OddEvenThread {

    public static void main(String[] args) {
        Printer print = new Printer();
        Thread t1 = new Thread(new NumTask(10, print, true), "EvenThread : ");
        Thread t2 = new Thread(new NumTask(10, print, false), "OddThread : ");
        t1.start();
        t2.start();
    }

    static class NumTask implements Runnable{

        private int max;
        private Printer printer;
        private boolean isEven;

        public NumTask(int max, Printer printer, boolean isEven){
            this.max = max;
            this.printer = printer;
            this.isEven = isEven;
        }

        @Override
        public void run() {
            int number = isEven ? 2:1;

            while (number < max){
                if(isEven){
                    printer.printEven(number);
                }else{
                    printer.printOdd(number);
                }
                number += 2;
            }
        }
    }

    static class Printer{

        private boolean isOdd = false;

        public void printEven(int number) {
            synchronized (this){
                while (isOdd == false){
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + number);
                isOdd = false;
                this.notifyAll();
            }
        }

        public void printOdd(int number) {
            synchronized (this){
                while (isOdd == true){
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + number);
                isOdd = true;
                this.notifyAll();
            }
        }
    }
}
