package TASK4_1;

public class StandardAuction extends Auction {

    public StandardAuction(AuctionItem item) {
        super(item);
    }

    @Override
    protected void displayWelcomeMessage() {
        System.out.println("🏷️ Welcome to the Standard Auction for: " + item.getItemName());
    }

    @Override
    protected void conductBidding() {
        System.out.println("💬 Conducting standard bidding for: " + item.getItemName());
        item.notifyObservers("The bidding for '" + item.getItemName() + "' has started.");
    }
}
