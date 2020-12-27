package task1.debit;

import task1.debit.DebitCard;

public class VirtualDebitCard implements DebitCard {
    @Override
    public void info() {
        System.out.println("using virtual card");
    }
}
