package messaging;

import java.util.LinkedList;
import java.util.Queue;

class MessageQueue {
    private Queue<String> queue = new LinkedList<>();
    private int capacity;

    public MessageQueue(int capacity) {
        this.capacity = capacity;
    }

    public synchronized void produce(String message) throws InterruptedException {
        while (queue.size() == capacity) {
            wait();
        }
        queue.add(message);
        System.out.println("Produced: " + message);
        notify();
    }

    public synchronized String consume() throws InterruptedException {
        while (queue.isEmpty()) {
            wait();
        }
        String message = queue.poll();
        System.out.println("Consumed: " + message);
        notify();
        return message;
    }
}
