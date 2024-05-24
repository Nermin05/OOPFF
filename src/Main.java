import business.concretes.CustomerManager;
import business.concretes.DriverManager;
import business.concretes.UserManager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        Scanner scanner=new Scanner(System.in);
        UserManager userManager=new UserManager();
        CustomerManager  customerManager=new CustomerManager(userManager);
        DriverManager driverManager=new DriverManager(customerManager);
        while (true) {
            System.out.print("""
                    1->Customer
                    2->Driver
                    Choose:""");
            int sec=scanner.nextInt();
            switch (sec) {
                case 1: userManager.register();
                    userManager.login();
                    System.out.println("""
                            1->Taxi sifaris etmek
                            2->Taxini legv etmek
                            0->Cixis
                            Seciminiz: """);
                    int sec2=scanner.nextInt();
                    switch (sec2) {
                        case 1: customerManager.order(); break;
                        case 2: customerManager.reject(); break;
                        default: System.exit(0);

                    }
break;
                case 2:
                    driverManager.accept();break;
                default:System.exit(0);

            }
        }
    }

}