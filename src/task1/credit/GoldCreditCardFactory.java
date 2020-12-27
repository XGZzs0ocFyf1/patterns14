package task1.credit;

import task1.Card;
import task1.CardFactory;

public class GoldCreditCardFactory implements CreditCardFactory {
    @Override
    public Card createCard() {
        return new GoldCreditCard();
    }
}
