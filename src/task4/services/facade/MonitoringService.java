package task4.services.facade;

import task4.LoanApplication;
import task4.services.AbstractService;

public class MonitoringService extends AbstractService {


    @Override
    public void handleLoanApplicationInformation(LoanApplication loanApplication) {
        System.out.println("Служба мониторинга получила кредитную заявку "+loanApplication);
    }
}
