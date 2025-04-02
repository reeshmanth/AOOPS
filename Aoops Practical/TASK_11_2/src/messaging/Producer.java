package messaging;

class Producer extends Thread {
    private MessageQueue messageQueue;

    public Producer(MessageQueue messageQueue) {
        this.messageQueue = messageQueue;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            try {
                messageQueue.produce("Message " + i);
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
