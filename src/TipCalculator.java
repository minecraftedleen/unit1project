import java.io.*;
import java.util.Scanner;
public class TipCalculator {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the number of people in your group: ");

        final int PEOPLENUMBER = scan.nextInt();
        System.out.print("Enter the tip percentage: ");
        final double TIPPERCENTAGE = scan.nextDouble() / 100;
        double price = 0;
        double tempPrice = 0;
        int rounder = 2;
        while (tempPrice >= 0) {
            System.out.print("Enter a price(negative number to end): ");
            tempPrice = scan.nextDouble();
            if (tempPrice>0) {
                price += tempPrice;
            }

        }

        double totalTip = TIPPERCENTAGE * price;
        double tipPerPerson = totalTip / PEOPLENUMBER;
        double billAfterTip = price + totalTip;
        double costPerPersonNoTip = price / PEOPLENUMBER;
        double costPerPerson = billAfterTip / PEOPLENUMBER;

        totalTip = Math.round(totalTip * Math.pow(10, rounder)) / Math.pow(10, rounder);
        tipPerPerson = Math.round(tipPerPerson * Math.pow(10, rounder)) / Math.pow(10, rounder);
        billAfterTip = Math.round(billAfterTip * Math.pow(10, rounder)) / Math.pow(10, rounder);
        costPerPersonNoTip = Math.round(costPerPersonNoTip * Math.pow(10, rounder)) / Math.pow(10, rounder);
        costPerPerson = Math.round(costPerPerson * Math.pow(10, rounder)) / Math.pow(10, rounder);
        System.out.println("---------------------------------");
        System.out.println("Total bill before tip: $" + price);
        System.out.println("Total tip percentage: " + (int)(TIPPERCENTAGE * 100) + "%");
        System.out.println("Total tip: $" + totalTip);
        System.out.println("Total bill with tip: $" + billAfterTip);
        System.out.println("Cost per person before tip: $" + costPerPersonNoTip);
        System.out.println("Tip per person: $" + tipPerPerson);
        System.out.println("Total cost per person: $" + costPerPerson);
        System.out.println("---------------------------------");
        }

}
