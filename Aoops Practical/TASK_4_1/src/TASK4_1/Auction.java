package TASK4_1;

public abstract class Auction {
    protected AuctionItem item;

    public Auction(AuctionItem item) {
        this.item = item;
    }

    public final void startAuction() {
        displayWelcomeMessage();
        notifyItemAvailable();
        conductBidding();
        endAuction();
    }

    protected abstract void displayWelcomeMessage();

    private void notifyItemAvailable() {
        item.notifyObservers("The item '" + item.getItemName() + "' is now available for bidding.");
    }

    protected abstract void conductBidding();

    private void endAuction() {
        item.notifyObservers("The auction for '" + item.getItemName() + "' has ended. Thank you for participating!");
    }
}
