package task1.debit;

import task1.Card;

public class VirtualDebitCardFactory implements DebitCardFactory{
    @Override
    public Card createCard() {
        return new VirtualDebitCard();
    }
}
