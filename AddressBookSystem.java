import java.util.*;
public class AddressBookSystem {
    private Map<String, AddressBook> addressBooks;
    private Scanner scanner;

    public AddressBookSystem() {
        addressBooks = new HashMap<>();
        scanner = new Scanner(System.in);
    }

    public void createAddressBook() {
        System.out.println("Enter the name of the new address book:");
        String name = scanner.nextLine();
        if (addressBooks.containsKey(name)) {
            System.out.println("An address book with this name already exists.\n");
        } else {
            AddressBook newAddressBook = new AddressBook(name);
            addressBooks.put(name, newAddressBook);
            System.out.println("Address book '" + name + "' created successfully.\n");
        }
    }

    public AddressBook selectAddressBook() {
        System.out.println("Enter the name of the address book:");
        String name = scanner.nextLine();
        if (addressBooks.containsKey(name)) {
            return addressBooks.get(name);
        } else {
            System.out.println("Address book not found.\n");
            return null;
        }
    }

    public void displayAllAddressBooks() {
        if (addressBooks.isEmpty()) {
            System.out.println("No address books available.\n");
        } else {
            System.out.println("Available Address Books:");
            for (String name : addressBooks.keySet()) {
                System.out.println(name);
            }
            System.out.println();
        }
    }

    public void start() {
        int choice;
        do {
            System.out.println("Address Book System Menu:");
            System.out.println("1. Create a new address book");
            System.out.println("2. Select an address book");
            System.out.println("3. Display all address books");
            System.out.println("4. Exit");

            System.out.println("Enter your choice:");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    createAddressBook();
                    break;
                case 2:
                    AddressBook selectedBook = selectAddressBook();
                    if (selectedBook != null) {
                        selectedBook.start();
                    }
                    break;
                case 3:
                    displayAllAddressBooks();
                    break;
                case 4:
                    System.out.println("Exiting Address Book System.");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.\n");
                    break;
            }
        } while (choice != 4);

        scanner.close();
    }


    public static void main(String[] args) {
        AddressBookSystem system = new AddressBookSystem();
        system.start();
    }
}