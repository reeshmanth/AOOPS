package TASK4_1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the name of the auction item:");
        String itemName = scanner.nextLine();
        AuctionItem item = new AuctionItem(itemName);

        System.out.println("Enter the name of the first bidder:");
        Bidder bidder1 = new Bidder(scanner.nextLine());

        System.out.println("Enter the name of the second bidder:");
        Bidder bidder2 = new Bidder(scanner.nextLine());

        System.out.println("Enter the name of the third bidder:");
        Bidder bidder3 = new Bidder(scanner.nextLine());

        item.addObserver(bidder1);
        item.addObserver(bidder2);

        System.out.println("Choose auction type:");
        System.out.println("1. Standard Auction");
        System.out.println("2. Reserve Auction");
        int auctionType = scanner.nextInt();

        Auction auction;
        if (auctionType == 1) {
            auction = new StandardAuction(item);
        } else {
            System.out.println("Enter the reserve price:");
            double reservePrice = scanner.nextDouble();
            auction = new ReserveAuction(item, reservePrice);
        }

        System.out.println("\n🎉 Auction Events Start!\n");
        auction.startAuction();

        while (true) {
            System.out.println("\n📢 Subscription Management:");
            System.out.println("1. Subscribe a bidder");
            System.out.println("2. Unsubscribe a bidder");
            System.out.println("3. End subscription management");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.println("Enter the name of the bidder to subscribe:");
                String name = scanner.nextLine();
                if (name.equalsIgnoreCase(bidder1.getName())) {
                    item.addObserver(bidder1);
                } else if (name.equalsIgnoreCase(bidder2.getName())) {
                    item.addObserver(bidder2);
                } else if (name.equalsIgnoreCase(bidder3.getName())) {
                    item.addObserver(bidder3);
                } else {
                    System.out.println("❌ Bidder not found.");
                }
            } else if (choice == 2) {
                System.out.println("Enter the name of the bidder to unsubscribe:");
                String name = scanner.nextLine();
                if (name.equalsIgnoreCase(bidder1.getName())) {
                    item.removeObserver(bidder1);
                } else if (name.equalsIgnoreCase(bidder2.getName())) {
                    item.removeObserver(bidder2);
                } else if (name.equalsIgnoreCase(bidder3.getName())) {
                    item.removeObserver(bidder3);
                } else {
                    System.out.println("❌ Bidder not found.");
                }
            } else if (choice == 3) {
                System.out.println("\n📢 Subscription management ended.");
                break;
            } else {
                System.out.println("❌ Invalid choice. Try again.");
            }
        }

        item.notifyObservers("The auction for '" + item.getItemName() + "' has officially ended.");
        System.out.println("\n🎉 Auction Events Ended!");
        scanner.close();
    }
}
