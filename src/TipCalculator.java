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
        int divider = 0;
        double eachCost;
        double change = 0;
        double temp;
        String everyCost = "The " + PEOPLENUMBER + " people will pay ";
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
        System.out.println("Average cost per person before tip: $" + costPerPersonNoTip);
        System.out.println("Tip per person: $" + tipPerPerson);
        System.out.println("Average cost per person: $" + costPerPerson);
        System.out.println("---------------------------------");
        System.out.println();
        System.out.println("Time to divide the price!");
        temp = billAfterTip;
        while (divider != PEOPLENUMBER) {
            System.out.print("Enter a cost person " + (divider + 1 + " will pay: "));
            eachCost = scan.nextDouble();
            billAfterTip -= eachCost;
            System.out.println("Remaining Cost: " + Math.round(billAfterTip * Math.pow(10, rounder)) / Math.pow(10, rounder));
            everyCost += "$" + eachCost;
            if (divider < (PEOPLENUMBER - 1)) {
                everyCost += ", ";
            }
            if (divider == (PEOPLENUMBER - 1)) {
                if (billAfterTip > 0) {
                    System.out.println("Not enough payment, try again!");
                    divider = -1;
                    billAfterTip = temp;
                    everyCost = "The " + PEOPLENUMBER + " people will pay ";
                }
                else {
                    change = billAfterTip * -1;
                }
            }
            divider += 1;
        }
        System.out.println(everyCost);
        System.out.println("Change: $" + Math.round(change * Math.pow(10, rounder)) / Math.pow(10, rounder));
    }


}
