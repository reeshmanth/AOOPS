package InLab1;

import java.util.HashMap;
import java.util.Map;

class ContactManager {
    private Map<String, String> contacts;

    public ContactManager() {
        this.contacts = new HashMap<>();
    }

    public void addContact(String name, String phoneNumber) {
        contacts.put(name, phoneNumber);
        System.out.println(name + " added.");
    }

    public String getPhoneNumber(String name) {
        return contacts.getOrDefault(name, "Contact not found.");
    }

    public void removeContact(String name) {
        if (contacts.remove(name) != null) {
            System.out.println(name + " removed.");
        } else {
            System.out.println("Contact not found.");
        }
    }
    public void listContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts available.");
        } else {
            System.out.println("Contacts List:");
            for (Map.Entry<String, String> entry : contacts.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }
}
