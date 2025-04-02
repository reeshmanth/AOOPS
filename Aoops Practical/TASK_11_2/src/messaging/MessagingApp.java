package messaging;

public class MessagingApp {
    public static void main(String[] args) {
        MessageQueue messageQueue = new MessageQueue(3);

        Producer producer = new Producer(messageQueue);
        Consumer consumer = new Consumer(messageQueue);

        producer.start();
        consumer.start();

        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Message processing completed.");
    }
}
