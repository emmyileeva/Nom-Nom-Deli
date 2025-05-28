package com.nomnomdeli.signatures;

import com.nomnomdeli.model.Sandwich;

// This class is an abstract class that represents a signature sandwich in the app.

public abstract class SignatureSandwich extends Sandwich {

    public SignatureSandwich(String size, String breadType, boolean toasted) {
        super(size, breadType, toasted);
    }

    // Every signature sandwich must have a name that describes it.
    public abstract String getSignatureName();
}
