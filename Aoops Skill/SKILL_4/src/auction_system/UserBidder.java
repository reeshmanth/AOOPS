package auction_system;

public class UserBidder implements Bidder {
    private String name;

    public UserBidder(String name) {
        this.name = name;
    }

    @Override
    public void update(String item, double newBid) {
        System.out.println(name + " has been notified: New bid of $" + newBid + " on " + item);
    }
}
