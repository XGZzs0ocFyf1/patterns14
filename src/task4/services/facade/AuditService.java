package task4.services.facade;

import task4.LoanApplication;
import task4.services.AbstractService;


public class AuditService extends AbstractService {

    @Override
    public void handleLoanApplicationInformation(LoanApplication loanApplication) {
        System.out.println("Служба аудита получила заявку "+ loanApplication);
    }
}
