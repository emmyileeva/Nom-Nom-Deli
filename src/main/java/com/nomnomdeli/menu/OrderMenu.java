package com.nomnomdeli.menu;

import com.nomnomdeli.model.Chip;
import com.nomnomdeli.model.Drink;
import com.nomnomdeli.model.Order;
import com.nomnomdeli.model.Sandwich;
import com.nomnomdeli.service.ReceiptWriter;
import com.nomnomdeli.data.OrderLogger;


import java.util.Scanner;

public class OrderMenu {
    private Scanner scanner;
    private Order currentOrder;

    public OrderMenu(Scanner scanner, Order currentOrder) {
        this.scanner = scanner;
        this.currentOrder = currentOrder;
    }

    // This method displays the order menu and handles user input
    public boolean showOrderMenu() {
        boolean inOrder = true;

        while (inOrder) {
            System.out.println("\n🥪 Order Menu 🥪");
            System.out.println("----------------------------");
            System.out.println("1) Add a sandwich");
            System.out.println("2) Add a signature sandwich");
            System.out.println("3) Add a drink");
            System.out.println("4) Add chips");
            System.out.println("5) View current order");
            System.out.println("6) Edit current order");
            System.out.println("7) Checkout");
            System.out.println("0) Cancel Order");
            System.out.print("Please select an option: ");

            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    SandwichMenu sandwichMenu = new SandwichMenu(scanner);
                    Sandwich sandwich = sandwichMenu.buildSandwich();
                    currentOrder.addSandwich(sandwich);
                    System.out.println("Sandwich added to your order!");
                    break;
                case "2":
                    SignatureSandwichMenu signatureMenu = new SignatureSandwichMenu(scanner);
                    Sandwich signatureSandwich = signatureMenu.chooseSignatureSandwich();
                    if (signatureSandwich != null) {
                        currentOrder.addSandwich(signatureSandwich);
                        System.out.println("Signature sandwich added to your order!");
                    } else {
                        System.out.println("No signature sandwich selected.");
                    }
                    break;
                case "3":
                    DrinkMenu drinkMenu = new DrinkMenu(scanner);
                    Drink drink = drinkMenu.buildDrink();
                    currentOrder.addDrink(drink);
                    System.out.println("Drink added to your order!");
                    break;
                case "4":
                    ChipMenu chipMenu = new ChipMenu(scanner);
                    Chip chip = chipMenu.buildChip();
                    currentOrder.addChip(chip);
                    System.out.println("Chips added to your order!");
                    break;
                case "5":
                    ViewOrderMenu viewOrderMenu = new ViewOrderMenu(scanner);
                    viewOrderMenu.viewCurrentOrder(currentOrder);
                    break;
                case "6":
                    EditOrderMenu editOrderMenu = new EditOrderMenu(scanner);
                    editOrderMenu.showEditOrderMenu(currentOrder);
                    break;
                case "7":
                    if (currentOrder.isEmpty()) {
                        System.out.println("Your order is empty. Please add items before checking out.");
                        break;
                    }
                    CheckoutMenu checkoutMenu = new CheckoutMenu(scanner);
                    boolean confirmed = checkoutMenu.showCheckoutMenu(currentOrder);

                    if (confirmed) {
                        ReceiptWriter.saveReceipt(currentOrder);
                        OrderLogger.appendToOrderHistory(currentOrder);
                        System.out.println("Thank you for your order! Your receipt has been saved.");
                        return true;
                    } else {
                        System.out.println("Order canceled. Returning to order menu.");
                    }
                    break;
                case "0":
                    System.out.println("Order cancelled. Returning to home menu.");
                    inOrder = false; // Exit the order menu
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        return false; // Return to home menu
    }
}
