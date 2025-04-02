package contacts;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ContactManager manager = new ContactManager();
        Scanner scanner = new Scanner(System.in);

        manager.addContact(new Contact("Reeshmanth", "9666665587", "reeshmanth@gmail.com"));
        manager.addContact(new Contact("Kusumitha", "9246481678", "kusumitha@gmail.com"));
        manager.addContact(new Contact("Sathvik", "9133333121", "sathvik@gmail.com"));

        System.out.println("All Contacts:");
        manager.displayAllContacts();

        System.out.println("\nGet Contact by Name (Enter Name):");
        String name = scanner.nextLine();
        Contact contact = manager.getContactByName(name);
        if (contact != null) {
            System.out.println("Found: " + contact);
        } else {
            System.out.println("Contact not found.");
        }

        System.out.println("\nRemoving Contact (Enter Name):");
        name = scanner.nextLine();
        manager.removeContact(name);

        System.out.println("\nContacts after removal:");
        manager.displayAllContacts();

        System.out.println("\nTotal Contacts: " + manager.getTotalContacts());

        scanner.close();
    }
}
