package multithreading;

public class ProducerConsumerExample {
    public static void main(String[] args) {
        MessageQueue queue = new MessageQueue(); 

        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);

        producer.start();
        consumer.start();
    }
}
