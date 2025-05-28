package com.nomnomdeli.signatures;

import com.nomnomdeli.toppings.*;

public class ProteinPowerhouse extends SignatureSandwich {

    public ProteinPowerhouse() {
        super("12", "Sourdough", true);
        addTopping(new Meat("Grilled Chicken", true));
        addTopping(new Meat("Turkey", false));
        addTopping(new Cheese("Swiss", false));
        addTopping(new RegularTopping("Lettuce"));
        addTopping(new RegularTopping("Bell Peppers"));
        addTopping(new RegularTopping("Mustard"));
    }

    @Override
    public String getSignatureName() {
        return "Protein Powerhouse";
    }
}
