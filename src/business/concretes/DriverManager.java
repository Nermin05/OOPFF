package business.concretes;

import business.abstracts.DriverService;
import business.abstracts.UserService;
import entities.Driver;
import entities.Pay;

import javax.xml.transform.Source;
import java.util.Collections;
import java.util.Scanner;

public class DriverManager implements DriverService, UserService {
    private CustomerManager customerManager;
    Driver driver = new Driver("Driver", "+994938328", 0.0, 0.0);

    public DriverManager(CustomerManager customerManager) {
        this.customerManager = customerManager;
    }

    private static final double BASE_FARE = 2.0;
    private static final double RATE_PER_KM = 1.0;
    private static final double AVERAGE_SPEED_KM_PER_HOUR = 30.0;

    private void calculateArrivalTime() {
        Collections.sort(customerManager.getDifferences());
            double distance = customerManager.getDifferences().get(0);
            double time = (distance / AVERAGE_SPEED_KM_PER_HOUR)*100;
        String formattedValue = String.format("%.0f", time);
        System.out.println( formattedValue + " deqiqeye orada olacaq.");


    }
    private  void calculateFare() {
        Collections.sort(customerManager.getDifferences());
        double difference = customerManager.getDifferences().get(0);
        double fee = BASE_FARE + (RATE_PER_KM * difference);
        String formattedValue = String.format("%.2f", fee);
        if (reject(fee)==true) {
            System.out.println("Gedis haqqi:" + formattedValue);
            Scanner scanner = new Scanner(System.in);
            System.out.println("""
                    Hansi ile odenilecek?
                    1->Nagd
                    2->Kart
                    """);
            int sec = scanner.nextInt();
            Pay pay;
            if (sec == 1) {
                pay = Pay.CASH;
            } else if (sec == 2) {
                pay = Pay.CREDI_CARD;
            } else {
                System.out.println("Yanlis secim.");
                return;
            }
            if (pay == Pay.CASH) {
                System.out.println("Nagd ile odenilecek.");
            } else {
                Scanner scanner1 = new Scanner(System.in);
                System.out.print("Kard nomresini daxil edin:");
                String cardNumber = scanner1.nextLine();
                if (!cardNumber.isEmpty()) {
                    System.out.println("Odenildi!");
                } else {
                    System.out.println("Kard nomresini daxil edin!");
                }
            }

        } else {
            System.out.println(driver.name()+" sizi qebul etmedi!");
        }
    }

    @Override
    public void accept() {
        Collections.sort(customerManager.getDifferences());
        double difference=customerManager.getDifferences().get(0);
        String formattedValue = String.format("%.3f", difference);

        System.out.print(driver.name()+" "+formattedValue+" km uzaqliqdadir. ");
        calculateArrivalTime();
        calculateFare();

    }
   private boolean reject(double fee) {
if(fee>5) {
    return true;
}
return false;
   }

    @Override
    public void register() throws IllegalAccessException {

    }

    @Override
    public void login() throws IllegalAccessException {

    }


}
