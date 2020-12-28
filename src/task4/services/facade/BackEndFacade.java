package task4.services.facade;

import task4.LoanApplication;


/**
 * Facade for Audit service, HistoryService and LogService
 * They are calling together
 */
public class BackEndFacade{


    //поскольку это java и возможно Spring скорее всего  будет @Autowired в через конструктор
    //но сейчас в конструкторе создаим новые инстансы
    private final AuditService auditService;
    private final MonitoringService monitoringService;
    private final LogService logService;


    public BackEndFacade() {
        this.auditService = new AuditService();
        this.monitoringService = new MonitoringService();
        this.logService = new LogService();
    }



    public void updateInfo(LoanApplication loanApplication){
        auditService.handleLoanApplicationInformation( loanApplication);
        monitoringService.handleLoanApplicationInformation( loanApplication);
        logService.handleLoanApplicationInformation( loanApplication);
    }


}
