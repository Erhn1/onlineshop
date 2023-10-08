package Examples;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class EraStore {
    static Scanner scan = new Scanner(System.in);
    static double VAT = 0.12;

    public static void main(String[] args) {
        myOrder();
    }

    static void myOrder() {
        System.out.print("Customer's Name: ");
        scan.nextLine();
        System.out.println(" ");
        System.out.println("***************************");
        System.out.println("WELCOME TO THE ERA'S STORE!");
        System.out.println("***************************");
        System.out.println(" ");
        
        List<Item> items = new ArrayList<>();

        for (int i = 1; i <= 3; i++) {
            System.out.print("ENTER ITEM " + i + ": ");
            String itemName = scan.nextLine();
            
            System.out.print("PRICE: ");
            double itemPrice = scan.nextDouble();
            scan.nextLine();
            
            System.out.print("QUANTITY: ");
            int itemQuantity = scan.nextInt();
            scan.nextLine();

            Item item = new Item(itemName, itemPrice, itemQuantity);
            items.add(item);

            double itemTotal = itemPrice * itemQuantity;
            System.out.println("ITEM " + i + "TOTAL: " + itemTotal + " php");
        }

        double subtotal = items.stream().mapToDouble(item -> item.getPrice() * item.getQuantity()).sum();
        double vat = VAT * subtotal;
        double totalCost = subtotal + vat;

        System.out.println(" ");
        System.out.println("********** INVOICE **********");
        System.out.println("Sub Total: " + subtotal + " php");
        System.out.println("VAT : " + vat + " php");
        System.out.println("Total Cost: " + totalCost + " php");

        double cashAmount;
        do {
            System.out.print("CASH: ");
            cashAmount = scan.nextDouble();

            if (cashAmount < totalCost) {
                System.out.println("NOT ENOUGH BALANCE.");
            }
        } while (cashAmount < totalCost);

        double change = cashAmount - totalCost;

        System.out.println("CHANGE: " + change + " php");
        System.out.println(" ");
        System.out.println("********** COME AGAIN! UWU>< **********");
    }
}

class Item {
    private String name;
    private double price;
    private int quantity;

    public Item(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}
