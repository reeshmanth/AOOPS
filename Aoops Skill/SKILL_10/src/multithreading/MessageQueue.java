package multithreading;

import java.util.LinkedList;
import java.util.Queue;

class MessageQueue {
    private Queue<String> queue = new LinkedList<>();
    private final int CAPACITY = 5; 

    public synchronized void produce(String message) throws InterruptedException {
        while (queue.size() == CAPACITY) {
            System.out.println("Queue is full. Producer is waiting...");
            wait(); 
        }
        queue.add(message);
        System.out.println("Produced: " + message);
        notify(); 
    }
    public synchronized String consume() throws InterruptedException {
        while (queue.isEmpty()) {
            System.out.println("Queue is empty. Consumer is waiting...");
            wait(); 
        }
        String message = queue.poll();
        System.out.println("Consumed: " + message);
        notify();
        return message;
    }
}
