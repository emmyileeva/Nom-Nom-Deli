package com.nomnomdeli.signatures;


import com.nomnomdeli.model.Sandwich;

public abstract class SignatureSandwich extends Sandwich {

    public SignatureSandwich(String size, String breadType, boolean toasted) {
        super(size, breadType, toasted);
    }

    public abstract String getSignatureName();
}
