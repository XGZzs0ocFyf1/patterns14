package task1;

import task1.credit.GoldCreditCardFactory;
import task1.credit.VirtualCreditCardFactory;
import task1.debit.GoldDebitCardFactory;
import task1.debit.VirtualDebitCardFactory;

public class FactoryCreator {

      static CardFactory createFactory(CardType type) {
        switch (type) {
            case GOLD_CREDIT:
                return new GoldCreditCardFactory();
            case VIRTUAL_CREDIT:
                return new VirtualCreditCardFactory();
            case VIRTUAL_DEBIT:
                return new VirtualDebitCardFactory();
            case GOLD_DEBIT:
                return new GoldDebitCardFactory();
            default:
                throw new IllegalArgumentException("Unknown CardType: " + type);
        }
    }
}
