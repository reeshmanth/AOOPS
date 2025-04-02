package auction_system;

import java.util.ArrayList;
import java.util.List;

public class Auctioneer {
    private List<Bidder> bidders = new ArrayList<>();

    public void registerBidder(Bidder bidder) {
        bidders.add(bidder);
    }

    public void notifyBidders(String item, double newBid) {
        for (Bidder bidder : bidders) {
            bidder.update(item, newBid);
        }
    }
}
