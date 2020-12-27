package task1.credit;

import task1.Card;

public class VirtualCreditCard implements CreditCard {


    @Override
    public void info() {
        System.out.println("Using virtual credit card");
    }
}
