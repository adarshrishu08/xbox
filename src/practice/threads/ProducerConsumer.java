package practice.threads;

import java.util.LinkedList;

public class ProducerConsumer {

    public static void main(String[] args) throws InterruptedException {
        ProducerConsumerExecution pc =  new ProducerConsumerExecution();
        Thread producer = new Thread(new Producer(pc), "Producer Thread");
        Thread consumer1 = new Thread(new Consumer(pc), "Consumer Thread 1");
        Thread consumer2 = new Thread(new Consumer(pc), "Consumer Thread 2");
        Thread consumer3 = new Thread(new Consumer(pc), "Consumer Thread 3");

        producer.start();
        consumer1.start();
        consumer2.start();
        consumer3.start();

    }
}

class Producer implements Runnable {

    ProducerConsumerExecution pc;

    public Producer(ProducerConsumerExecution pc){
        this.pc = pc;
    }
    @Override
    public void run() {
        try {
            pc.produce();
        } catch (InterruptedException Ie){
            System.out.println(Ie.getMessage());
        }
    }
}

class Consumer implements Runnable {

    ProducerConsumerExecution pc;

    public Consumer(ProducerConsumerExecution pc){
        this.pc = pc;
    }

    @Override
    public void run() {
        try {
            pc.consume();
        } catch (InterruptedException Ie){
            System.out.println(Ie.getMessage());
        }
    }
}

class ProducerConsumerExecution {

    LinkedList<Integer> list = new LinkedList<>();
    int capacity = 3;

    public void produce() throws InterruptedException{
        int value = 0;
        while(true){
            synchronized (this) {

                //Wait while Producer Capacity is full
                while (list.size() == capacity) {
                    wait();
                }

                list.add(++value);
                System.out.println("Produced Value :"+value +" Thread :"+ Thread.currentThread().getName());
                notify();
                Thread.sleep(2000);
            }
        }
    }

    public void consume() throws InterruptedException{

        while(true){
            synchronized (this){

                // Wait while List is Empty to Consume
                while(list.size() == 0){
                    wait();
                }

                int val = list.removeFirst();
                System.out.println("consumed value :"+val+" Thread :"+ Thread.currentThread().getName());
                notify();
                Thread.sleep(2000);
            }
        }

    }
}
