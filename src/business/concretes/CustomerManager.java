package business.concretes;

import business.abstracts.CustomerService;
import business.abstracts.UserService;
import entities.Customer;
import entities.Driver;
import entities.User;import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerManager implements CustomerService, UserService {
    private final List<User> users;
    private final UserManager userManager;
   private final List<Double> differences;

    public CustomerManager(UserManager userManager) {
        this.users = new ArrayList<>();
        differences = new ArrayList<>();
        this.userManager = userManager;
    }

    @Override
    public void order() {
        Scanner scanner = new Scanner(System.in);
        Driver driver = new Driver("Driver", "+994938328", 0.0, 0.0);

        System.out.print("""
                Enter your coordinates ->
                X: """);
        double x = scanner.nextDouble();
        System.out.print("Y: ");
        double y = scanner.nextDouble();

        User user = new User(x, y);
        System.out.println("Your location: " + user.getX() + "," + user.getY());
        users.add(user);

        int i = 1;
        for (User user1 : users) {
            double difference = Math.sqrt(Math.pow((user1.getX() - driver.X()), 2) + Math.pow((user1.getY() - driver.Y()), 2));
            String formattedValue = String.format("%.3f", difference);

            System.out.println(i++ + ") " + userManager.getUserNames().get(users.indexOf(user1)) + ": " + user1.getX() + "," + user1.getY());
            System.out.println(driver.name() + " sizden " + formattedValue + " km uzaqliqdadir");
            differences.add(difference);
        }
    }

    @Override
    public void reject() {
        System.out.println("Taxi legv edildi!");
        System.exit(0);
    }

    public List<Double> getDifferences() {
        return differences;
    }


    @Override
    public void register() throws IllegalAccessException {

    }

    @Override
    public void login() throws IllegalAccessException {

    }


}


