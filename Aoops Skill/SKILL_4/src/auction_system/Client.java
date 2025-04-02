package auction_system;

public class Client {
    public static void main(String[] args) {

        Auctioneer auctioneer = new Auctioneer();


        Bidder bidder1 = new UserBidder("Alice");
        Bidder bidder2 = new UserBidder("Bob");
        auctioneer.registerBidder(bidder1);
        auctioneer.registerBidder(bidder2);


        LiveAuction auction = new LiveAuction("Laptop", auctioneer);
        auction.startAuction();

        auction.placeBid(500, "Alice");
        auction.placeBid(700, "Bob");
        auction.placeBid(600, "Alice");
    }
}
