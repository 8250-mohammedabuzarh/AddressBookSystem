import java.util.*;
class AddressBook {
    private List<Contact> contacts;
    private String name;
    private Scanner scanner;

    public AddressBook(String name) {
        this.name = name;
        contacts = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void addContact() {
        System.out.println("Enter first name:");
        String firstName = scanner.nextLine();
        System.out.println("Enter last name:");
        String lastName = scanner.nextLine();
        System.out.println("Enter address:");
        String address = scanner.nextLine();
        System.out.println("Enter city:");
        String city = scanner.nextLine();
        System.out.println("Enter state:");
        String state = scanner.nextLine();
        System.out.println("Enter zip code:");
        String zip = scanner.nextLine();
        System.out.println("Enter phone number:");
        String phoneNumber = scanner.nextLine();
        System.out.println("Enter email:");
        String email = scanner.nextLine();

        Contact newContact = new Contact(firstName, lastName, address, city, state, zip, phoneNumber, email);
        contacts.add(newContact);
        System.out.println("Contact added successfully.\n");
    }
    public void editContact() {
        System.out.println("Enter first name of the contact to edit:");
        String firstName = scanner.nextLine();
        System.out.println("Enter last name of the contact to edit:");
        String lastName = scanner.nextLine();

        boolean found = false;
        for (Contact contact : contacts) {
            if (contact.getFirstName().equals(firstName) && contact.getLastName().equals(lastName)) {
                System.out.println("Contact found. What do you want to edit?");
                System.out.println("1. First Name");
                System.out.println("2. Last Name");
                System.out.println("3. Address");
                System.out.println("4. City");
                System.out.println("5. State");
                System.out.println("6. Zip Code");
                System.out.println("7. Phone Number");
                System.out.println("8. Email");
                System.out.println("9. Exit");

                System.out.println("Enter your choice:");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        System.out.println("Enter new first name:");
                        String newFirstName = scanner.nextLine();
                        contact.setFirstName(newFirstName);
                        break;
                    case 2:
                        System.out.println("Enter new last name:");
                        String newLastName = scanner.nextLine();
                        contact.setLastName(newLastName);
                        break;
                    case 3:
                        System.out.println("Enter new address:");
                        String newAddress = scanner.nextLine();
                        contact.setAddress(newAddress);
                        break;
                    case 4:
                        System.out.println("Enter new city:");
                        String newCity = scanner.nextLine();
                        contact.setCity(newCity);
                        break;
                    case 5:
                        System.out.println("Enter new state:");
                        String newState = scanner.nextLine();
                        contact.setState(newState);
                        break;
                    case 6:
                        System.out.println("Enter new zip code:");
                        String newZip = scanner.nextLine();
                        contact.setZip(newZip);
                        break;
                    case 7:
                        System.out.println("Enter new phone number:");
                        String newPhoneNumber = scanner.nextLine();
                        contact.setPhoneNumber(newPhoneNumber);
                        break;
                    case 8:
                        System.out.println("Enter new email:");
                        String newEmail = scanner.nextLine();
                        contact.setEmail(newEmail);
                        break;
                    case 9:
                        System.out.println("Exiting edit mode.");
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 9.\n");
                        break;
                }

                System.out.println("Contact updated successfully.\n");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Contact not found.\n");
        }
    }
    public void deleteContact() {
        System.out.println("Enter first name of the contact to delete:");
        String firstName = scanner.nextLine();
        System.out.println("Enter last name of the contact to delete:");
        String lastName = scanner.nextLine();

        Iterator<Contact> iterator = contacts.iterator();
        boolean found = false;
        while (iterator.hasNext()) {
            Contact contact = iterator.next();
            if (contact.getFirstName().equals(firstName) && contact.getLastName().equals(lastName)) {
                iterator.remove();
                System.out.println("Contact deleted successfully.\n");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Contact not found.\n");
        }
    }
    public void displayContacts() {
        if (contacts.isEmpty()) {
            System.out.println("Address book is empty.\n");
        } else {
            System.out.println("Contacts in Address Book '" + name + "':");
            for (Contact contact : contacts) {
                System.out.println(contact);
            }
            System.out.println();
        }
    }

    public void start() {
        int choice;
        do {
            System.out.println("Address Book Menu - " + name + ":");
            System.out.println("1. Add a new contact");
            System.out.println("2. Edit an existing contact");
            System.out.println("3. Delete a contact");
            System.out.println("4. Display all contacts");
            System.out.println("5. Exit");

            System.out.println("Enter your choice:");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addContact();
                    break;
                case 2:
                    editContact();
                    break;
                case 3:
                    deleteContact();
                    break;
                case 4:
                    displayContacts();
                    break;
                case 5:
                    System.out.println("Exiting Address Book '" + name + "'.");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.\n");
                    break;
            }
        } while (choice != 5);
    }


    public String getName() {
        return name;
    }
}