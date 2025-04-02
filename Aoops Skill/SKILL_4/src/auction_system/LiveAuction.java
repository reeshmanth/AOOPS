package auction_system;

public class LiveAuction extends Auction {
    private Auctioneer auctioneer;

    public LiveAuction(String item, Auctioneer auctioneer) {
        super(item);
        this.auctioneer = auctioneer;
    }

    @Override
    protected void conductBidding() {
        System.out.println("Live bidding started for: " + item);
    }

    public void placeBid(double amount, String bidderName) {
        if (amount > highestBid) {
            highestBid = amount;
            System.out.println(bidderName + " placed a bid of $" + amount);
            auctioneer.notifyBidders(item, amount);
        } else {
            System.out.println("Bid rejected. $" + amount + " is less than the highest bid.");
        }
    }
}
