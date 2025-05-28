package com.nomnomdeli.signatures;

import com.nomnomdeli.toppings.*;

public class GreenGoddessWrap extends SignatureSandwich {

    public GreenGoddessWrap() {
        super("8", "Lettuce Wrap", false);
        addTopping(new Meat("Hummus", false));
        addTopping(new Cheese("Feta", false));
        addTopping(new RegularTopping("Cucumber"));
        addTopping(new RegularTopping("Avocado"));
        addTopping(new RegularTopping("Spinach"));
        addTopping(new RegularTopping("Sprouts"));
        addTopping(new RegularTopping("Pesto"));
    }

    @Override
    public String getSignatureName() {
        return "Green Goddess Wrap";
    }
}
