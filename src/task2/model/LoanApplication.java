package task2.model;


/*
 * Минимальный состав заявки включает информацию о клиенте (ФИО, персональные
 * данные, данные о доходе, кредитная история и так далее), условиях кредита (процентная
 * ставка, срок, ежемесячный платеж) и т.д.*/
public class LoanApplication {


    private Client client;
    private LoanConditions loanConditions;

    public LoanApplication(Client client, LoanConditions loanConditions) {
        this.client = client;
        this.loanConditions = loanConditions;
    }

    public Client getClient() {
        return client;
    }

    public LoanConditions getLoanConditions() {
        return loanConditions;
    }
}
