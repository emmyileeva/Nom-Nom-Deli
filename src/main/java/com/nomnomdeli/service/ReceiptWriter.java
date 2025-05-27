package com.nomnomdeli.service;

import com.nomnomdeli.model.Order;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;

public class ReceiptWriter {

    public static void saveReceipt(Order order) {
        String timestamp = order.getOrderTime().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"));
        String receiptFileName = "receipts/" + timestamp + ".txt";

        try (FileWriter writer = new FileWriter(receiptFileName)) {
            writer.write(order.toString());
            System.out.println("Receipt saved to " + receiptFileName);
        } catch (IOException e) {
            System.err.println("Error saving receipt: " + e.getMessage());
        }
    }

    public static void appendToOrderHistory(Order order) {
        String historyFileName = "receipts/order_history.csv";
        File historyFile = new File(historyFileName);
        boolean newFile = !historyFile.exists();

        try (FileWriter writer = new FileWriter(historyFile, true)) {
            if (newFile) {
                writer.write("OrderID,Timestamp,TotalPrice,Sandwiches,Drinks,Chips\n"); // Write header if file is new
            }
            // Write the order details
            String orderDetails = String.format("%s,%s,%.2f,%d,%d,%d\n",
                    order.getOrderId(),
                    order.getOrderTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
                    order.getTotalPrice(),
                    order.getSandwiches().size(),
                    order.getDrinks().size(),
                    order.getChips().size()
            );
            writer.write(orderDetails);
        } catch (IOException e) {
            System.err.println("Error appending to order history: " + e.getMessage());
        }
    }
}


