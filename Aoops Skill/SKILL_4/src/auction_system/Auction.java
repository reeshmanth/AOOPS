package auction_system;

public abstract class Auction {
    protected String item;
    protected double highestBid;

    public Auction(String item) {
        this.item = item;
        this.highestBid = 0.0;
    }


    public final void startAuction() {
        initializeAuction();
        conductBidding();
        finalizeAuction();
    }

    protected void initializeAuction() {
        System.out.println("Auction started for: " + item);
    }

    protected abstract void conductBidding();

    protected void finalizeAuction() {
        System.out.println("Auction ended for: " + item + ". Winning bid: $" + highestBid);
    }

    public void setHighestBid(double bid) {
        this.highestBid = bid;
    }
}
