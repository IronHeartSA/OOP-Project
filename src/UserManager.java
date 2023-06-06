import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UserManager {
    private Map<String, String> users;

    public UserManager() {
        users = new HashMap<>();
    }

    public void registerUser() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Registration");
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        // Check if the username already exists
        if (users.containsKey(username)) {
            System.out.println("Username already exists. Please choose a different username.");
            return;
        }

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        // Add the new user to the users map
        users.put(username, password);

        System.out.println("Registration successful!");
    }

    public boolean loginUser() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Login");
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        // Check if the username exists
        if (!users.containsKey(username)) {
            System.out.println("Invalid username. Please try again.");
            return false;
        }

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        // Check if the password is correct
        String storedPassword = users.get(username);
        if (password.equals(storedPassword)) {
            System.out.println("Login successful!");
            return true;
        } else {
            System.out.println("Incorrect password. Please try again.");
            return false;
        }
    }
}
