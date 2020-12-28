package task4.services;

import task4.LoanApplication;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractService {

    protected List<LoanApplication> loanApplications = new ArrayList<>();

    public abstract void handleLoanApplicationInformation(LoanApplication loanApplication);
}
