package practice.threads;

public class NumberAlphabetThread {

    static int boundary = 26;
    static volatile int count = 0;
    static volatile int ascii = 65;
    static volatile boolean isNumber = true;
    public static void main(String[] args) {
        Printer printer = new Printer();
        Thread numberThread = new Thread(new NumberThread(count,boundary,printer), "Number Thread-1");
        Thread alphabetThread = new Thread(new NumberThread(count,boundary,printer), "Alphabet Thread-1");
        numberThread.start();
        alphabetThread.start();
    }

    static class NumberThread implements Runnable {
        int count;
        int boundary;
        Printer printer;

        public NumberThread(int count, int boundary, Printer printer) {
            this.count = count;
            this.boundary = boundary;
            this.printer = printer;
        }

        @Override
        public void run()  {
            while (count == boundary){
                if(isNumber){
                    printer.printNumber();
                } else {
                    printer.printAlbhabet();
                }
            }
        }
    }

    static class Printer  {

        public void printNumber(){
            synchronized (this){
                while (isNumber == false){
                    try {
                        this.wait();
                    } catch (InterruptedException ie){
                        ie.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName()+" "+ count);
                count++;
                isNumber = true;
                this.notifyAll();
            }
        }

        public void printAlbhabet() {
            synchronized (this){
                while (isNumber == true){
                    try {
                        this.wait();
                    } catch (InterruptedException ie){
                        ie.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName()+" "+(char)ascii+count);
                count++;
                isNumber =  false;
                this.notifyAll();
            }
        }
    }

}
