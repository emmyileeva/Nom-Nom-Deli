package com.nomnomdeli.menu;

import com.nomnomdeli.model.Chip;
import com.nomnomdeli.model.Drink;
import com.nomnomdeli.model.Order;
import com.nomnomdeli.model.Sandwich;
import com.nomnomdeli.service.ReceiptWriter;
import com.nomnomdeli.data.OrderLogger;
import com.nomnomdeli.utils.ColorTextHelper;

import java.util.Scanner;

// This class handles the main order menu where users can add items to their order, view/edit their order, and proceed to checkout.

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
            System.out.println();
            System.out.println(ColorTextHelper.colorize("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~", ColorTextHelper.AQUA));
            System.out.println(ColorTextHelper.colorize("🥗  O R D E R   M E N U  🥒", ColorTextHelper.AQUA));
            System.out.println(ColorTextHelper.colorize("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~", ColorTextHelper.AQUA));
            System.out.println();
            System.out.println(ColorTextHelper.colorize("🌱 Build your fresh & healthy sandwich! 🌱", ColorTextHelper.MINT));
            System.out.println();
            System.out.println(ColorTextHelper.colorize("────────────────────────────────────", ColorTextHelper.FRESH));
            System.out.println();
            System.out.println(ColorTextHelper.colorize("1) 🥬 Build your own sandwich", ColorTextHelper.LIME));
            System.out.println(ColorTextHelper.colorize("2) 🥑 Add a signature sandwich", ColorTextHelper.LIME));
            System.out.println(ColorTextHelper.colorize("3) 🥤 Add a drink", ColorTextHelper.LIME));
            System.out.println(ColorTextHelper.colorize("4) 🥕 Add some chips", ColorTextHelper.LIME));
            System.out.println(ColorTextHelper.colorize("5) 👀 View your order", ColorTextHelper.LIME));
            System.out.println(ColorTextHelper.colorize("6) ✏️ Edit your order", ColorTextHelper.LIME));
            System.out.println(ColorTextHelper.colorize("7) 💚 Checkout & enjoy", ColorTextHelper.LIME));
            System.out.println(ColorTextHelper.colorize("0) ❌ Cancel Order", ColorTextHelper.PINK));
            System.out.println();
            System.out.print(ColorTextHelper.colorize("What would you like to do? ", ColorTextHelper.LIME));

            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    SandwichMenu sandwichMenu = new SandwichMenu(scanner);
                    Sandwich sandwich = sandwichMenu.buildSandwich();
                    currentOrder.addSandwich(sandwich);
                    System.out.println(ColorTextHelper.colorize("🥬 Your custom sandwich is added! 🥑", ColorTextHelper.MINT));
                    break;
                case "2":
                    SignatureSandwichMenu signatureMenu = new SignatureSandwichMenu(scanner);
                    Sandwich signatureSandwich = signatureMenu.chooseSignatureSandwich();
                    if (signatureSandwich != null) {
                        currentOrder.addSandwich(signatureSandwich);
                        System.out.println(ColorTextHelper.colorize("🥑 Signature sandwich added! 🥗", ColorTextHelper.MINT));
                    } else {
                        System.out.println(ColorTextHelper.colorize("🌱 No signature sandwich selected.", ColorTextHelper.PINK));
                    }
                    break;
                case "3":
                    DrinkMenu drinkMenu = new DrinkMenu(scanner);
                    Drink drink = drinkMenu.buildDrink();
                    currentOrder.addDrink(drink);
                    System.out.println(ColorTextHelper.colorize("🥤 Drink added! 💦", ColorTextHelper.MINT));
                    break;
                case "4":
                    ChipMenu chipMenu = new ChipMenu(scanner);
                    Chip chip = chipMenu.buildChip();
                    currentOrder.addChip(chip);
                    System.out.println(ColorTextHelper.colorize("🥕 Chips added! 😋", ColorTextHelper.MINT));
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
                        System.out.println(ColorTextHelper.colorize("🛒 Your order is empty. Please add some items first!", ColorTextHelper.PINK));
                        break;
                    }
                    CheckoutMenu checkoutMenu = new CheckoutMenu(scanner);
                    boolean confirmed = checkoutMenu.showCheckoutMenu(currentOrder);

                    if (confirmed) {
                        ReceiptWriter.saveReceipt(currentOrder);
                        OrderLogger.appendToOrderHistory(currentOrder);
                        System.out.println();
                        System.out.println(ColorTextHelper.colorize("💚 Thank you for your order! Your receipt is saved. 🌱", ColorTextHelper.MINT));
                        System.out.println();
                        return true;
                    } else {
                        System.out.println();
                        System.out.println(ColorTextHelper.colorize("❌ Order canceled. Back to the menu!", ColorTextHelper.PINK));
                        System.out.println();
                    }
                    break;
                case "0":
                    System.out.println();
                    System.out.println(ColorTextHelper.colorize("❌ Order cancelled. Returning to home menu.", ColorTextHelper.PINK));
                    System.out.println();
                    inOrder = false; // Exit the order menu
                    break;
                default:
                    System.out.println();
                    System.out.println(ColorTextHelper.colorize("🚫 Invalid option. Please try again.", ColorTextHelper.PINK));
                    System.out.println();
            }
        }
        return false; // Return to home menu
    }
}
