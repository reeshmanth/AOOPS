package TASK4_1;

public class ReserveAuction extends Auction {
    private double reservePrice;

    public ReserveAuction(AuctionItem item, double reservePrice) {
        super(item);
        this.reservePrice = reservePrice;
    }

    @Override
    protected void displayWelcomeMessage() {
        System.out.println("🏷️ Welcome to the Reserve Auction for: " + item.getItemName() +
                " (Reserve Price: $" + reservePrice + ")");
    }

    @Override
    protected void conductBidding() {
        System.out.println("💬 Conducting reserve bidding for: " + item.getItemName());
        item.notifyObservers("The bidding for '" + item.getItemName() + "' has started. Reserve Price: $" + reservePrice);
    }
}
