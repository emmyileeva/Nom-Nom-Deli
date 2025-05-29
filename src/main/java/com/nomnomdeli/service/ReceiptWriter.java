package com.nomnomdeli.service;

import com.nomnomdeli.model.Order;
import com.nomnomdeli.utils.ColorTextHelper;

// This class handles saving the receipt of an order to a file.

import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;

public class ReceiptWriter {

    public static void saveReceipt(Order order) {
        // Format the timestamp for the receipt file name
        String timestamp = order.getOrderTime().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"));
        String receiptFileName = "receipts/" + timestamp + ".txt";

        // Write the order details to the receipt file
        try (FileWriter writer = new FileWriter(receiptFileName)) {
            writer.write(order.toString());
            System.out.println(ColorTextHelper.colorize("Receipt saved to " + receiptFileName, ColorTextHelper.MINT));
        } catch (IOException e) {
            System.out.println(ColorTextHelper.colorize("Error saving receipt: " + e.getMessage(), ColorTextHelper.PINK));
        }
    }
}


