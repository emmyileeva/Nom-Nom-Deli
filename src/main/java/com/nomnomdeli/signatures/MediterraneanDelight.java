package com.nomnomdeli.signatures;

import com.nomnomdeli.toppings.*;

// This class represents the Mediterranean Delight signature sandwich.

public class MediterraneanDelight extends SignatureSandwich{

    public MediterraneanDelight() {
        super("8", "Wheat", true);
        addTopping(new Meat("Falafel", false));
        addTopping(new Cheese("Goat Cheese", false));
        addTopping(new RegularTopping("Cucumber"));
        addTopping(new RegularTopping("Tomato"));
        addTopping(new RegularTopping("Onion"));
        addTopping(new RegularTopping("Greek Yogurt Sauce"));
    }

    @Override
    public String getSignatureName() {
        return "Mediterranean Delight";
    }
}
