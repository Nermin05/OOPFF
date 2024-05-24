package business.concretes;

import business.abstracts.UserService;
import entities.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserManager implements UserService {
    private final List<User> users;

    public UserManager() {
        users = new ArrayList<>();
    }

    public void register() throws IllegalAccessException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name: ");
        String name = scanner.nextLine();
        System.out.println("Enter email: ");
        String email = scanner.nextLine();
        System.out.println("Set password: ");
        String password = scanner.nextLine();
        System.out.println("Write password again: ");
        String passwordAgain = scanner.nextLine();
        if (password.length() < 8) {
            throw new IllegalAccessException("Your password is poor");
        } else if (!(password.equals(passwordAgain))) {
            throw new IllegalAccessException("Incorrect password");
        } else if (!(email.contains("@") && email.contains("."))) {
            throw new IllegalAccessException("Incorrect email");
        } else {
            User user = new User(name,email,password,passwordAgain);
            users.add(user);
            System.out.println("Successfully registered! " + user.getName());
            if (users.isEmpty()) {
                System.out.println("No registered customers.");
            } else {
                System.out.println("List of registered customers:");
                for (User user1 : users) {
                    System.out.println("Name: " + user1.getName() + ", Email: " + user1.getEmail());
                }
            }
        }
    }

    public void login() throws IllegalAccessException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your email: ");
        String email = scanner.nextLine();
        System.out.println("Enter your password: ");
        String password = scanner.nextLine();

        User foundUser = null;
        for (User user : users) {
            if (email.equals(user.getEmail()) && password.equals(user.getPassword())) {
                foundUser = user;
                break;
            }
        }

        if (foundUser != null) {
            System.out.println("Hi " + foundUser.getName());
        } else {
            throw new IllegalAccessException("Incorrect email or password");
        }
    }


    public List<String> getUserNames() {
        List<String> names = new ArrayList<>();
        for (User user : users) {
            names.add(user.getName());
        }
        return names;
    }






}

