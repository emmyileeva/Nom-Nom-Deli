package com.nomnomdeli.service;

import com.nomnomdeli.model.Order;


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
}


