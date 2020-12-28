package task4.services;

import task4.LoanApplication;

public abstract class AbstractService {

    protected LoanApplication loanApplication;

    public abstract void handleLoanApplicationInformation(LoanApplication loanApplication);
}
