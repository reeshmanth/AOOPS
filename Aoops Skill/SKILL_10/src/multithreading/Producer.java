package multithreading;

class Producer extends Thread {
    private MessageQueue queue;

    public Producer(MessageQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        int messageNumber = 1;
        while (true) {
            try {
                String message = "Message-" + messageNumber++;
                queue.produce(message);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
