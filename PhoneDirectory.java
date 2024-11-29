import java.util.HashMap;
import java.util.Scanner;

public class PhoneDirectory {
    private HashMap<String, String> directory;

    public PhoneDirectory() {
        directory = new HashMap<>();
    }

    public void addContact(String name, String phoneNumber) {
        directory.put(name, phoneNumber);
        System.out.println("Contact added successfully!");
    }

    public void searchContact(String name) {
        if (directory.containsKey(name)) {
            System.out.println("Name: " + name + ", Phone Number: " + directory.get(name));
        } else {
            System.out.println("Contact not found.");
        }
    }

    public void displayContacts() {
        if (directory.isEmpty()) {
            System.out.println("No contacts to display.");
        } else {
            System.out.println("All Contacts:");
            for (HashMap.Entry<String, String> entry : directory.entrySet()) {
                System.out.println("Name: " + entry.getKey() + ", Phone Number: " + entry.getValue());
            }
        }
    }

    public static void main(String[] args) {
        PhoneDirectory phoneDirectory = new PhoneDirectory();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nPhone Directory Menu:");
            System.out.println("1. Add Contact");
            System.out.println("2. Search Contact");
            System.out.println("3. Display All Contacts");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Phone Number: ");
                    String phoneNumber = scanner.nextLine();
                    phoneDirectory.addContact(name, phoneNumber);
                    break;
                case 2:
                    System.out.print("Enter Name to Search: ");
                    String searchName = scanner.nextLine();
                    phoneDirectory.searchContact(searchName);
                    break;
                case 3:
                    phoneDirectory.displayContacts();
                    break;
                case 4:
                    System.out.println("Exiting the Phone Directory. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
