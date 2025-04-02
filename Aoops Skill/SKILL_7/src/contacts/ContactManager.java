package contacts;

import java.util.*;

public class ContactManager {
    private Set<Contact> contactSet;
    private Map<String, Contact> contactMap;

    public ContactManager() {
        contactSet = new HashSet<>();
        contactMap = new HashMap<>();
    }

    public boolean addContact(Contact contact) {
        if (contactSet.add(contact)) {
            contactMap.put(contact.getName(), contact);
            return true;
        }
        return false;
    }

    public Contact getContactByName(String name) {
        return contactMap.get(name);
    }

    public void removeContact(String name) {
        Contact contact = contactMap.remove(name);
        if (contact != null) {
            contactSet.remove(contact);
        }
    }

    public void displayAllContacts() {
        for (Contact contact : contactSet) {
            System.out.println(contact);
        }
    }

    public int getTotalContacts() {
        return contactSet.size();
    }
}
