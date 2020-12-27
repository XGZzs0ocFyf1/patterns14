package task1;

/***
 * Задание №1. Реализовать фабрику создания кредитных карт с различными свойствами
 * https://www.sberbank.ru/ru/person/bank_cards/credit_cards
 * Примечание: Рекомендуется обратить внимание на порождающие шаблоны
 * проектирования.
 */
public class TaskOne {
    public static void main(String[] args) {

        //credit
        CardFactory goldFactory = FactoryCreator.createFactory(CardType.GOLD_CREDIT);
        Card creditGoldCard = goldFactory.createCard();
        creditGoldCard.info();

        CardFactory creditVirtualCardFactory = FactoryCreator.createFactory(CardType.VIRTUAL_CREDIT);
        Card creditVirtualCard = creditVirtualCardFactory.createCard();
        creditVirtualCard.info();


        //debit
        CardFactory debitGoldFactory = FactoryCreator.createFactory(CardType.GOLD_DEBIT);
        Card debitGoldCard = debitGoldFactory.createCard();
        debitGoldCard.info();

        CardFactory debitVirtualCardFactory = FactoryCreator.createFactory(CardType.VIRTUAL_DEBIT);
        Card debitVirtualCard = debitVirtualCardFactory.createCard();
        debitVirtualCard.info();


        //deliberate mistake
        CardFactory errorCardFactory = FactoryCreator.createFactory(CardType.FOOTBALL);
        Card errorCard = errorCardFactory.createCard();
        errorCard.info();



    }
}
