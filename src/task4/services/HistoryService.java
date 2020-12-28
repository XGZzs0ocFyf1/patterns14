package task4.services;

import task4.LoanApplication;
import task4.services.AbstractService;

public class HistoryService extends AbstractService {

    @Override
    public void handleLoanApplicationInformation(LoanApplication loanApplication) {
        System.out.println("Служба обработки кредитной истории получила заявку "+loanApplication);
    }

    public boolean isLoanApplicationValid(){

        //todo: validate loanApplicatio
        //todo: isValid(this.loanApplication)
        return true; //stub
    }
}
