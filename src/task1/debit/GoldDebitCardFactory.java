package task1.debit;

import task1.Card;

public class GoldDebitCardFactory implements DebitCardFactory{
    @Override
    public Card createCard() {
        return new GoldDebitCard();
    }
}
