package task1.debit;

import task1.debit.DebitCard;

public class GoldDebitCard implements DebitCard {
    @Override
    public void info() {
        System.out.println("Using gold card.");
    }
}
