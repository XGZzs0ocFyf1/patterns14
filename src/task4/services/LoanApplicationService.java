package task4.services;

import task4.LoanApplication;
import task4.services.facade.BackEndFacade;

import java.time.LocalDateTime;
import java.util.concurrent.ThreadLocalRandom;


/**
 * main service like class for working with loan applications
 * it initiate loan history checking and by the BackEndFacade calls monitoring
 * logging and audit services
 */
public class LoanApplicationService extends AbstractService{

    HistoryService historyService = new HistoryService();
    BackEndFacade facade = new BackEndFacade();
    //instead of createLoanApplication you can pass it here
    @Override
    public void handleLoanApplicationInformation(LoanApplication loanApplication) {
        this.loanApplication = loanApplication;
    }

    //create new LoanApplication
    public LoanApplication createLoanApplication(){

        //todo here should be some input from frontend
        //fixme now here is random content stub
        System.out.println("Создаю кредитную заявку"); //todo возможно все эти логи вообще в логгирование вынести
        LoanApplication loanApplication = new LoanApplication(ThreadLocalRandom.current().nextLong(0,100), "Application content");
        historyService.handleLoanApplicationInformation(loanApplication);
       // if (!historyService.isLoanApplicationValid())  //todo тут хорошо бы смотрелась какая-то валидация
        facade.updateInfo(loanApplication);
        return loanApplication;
    }

    public void updateLoanApplication(LoanApplication loanApplication){
        System.out.println("Произвожу корректировку кредитной заявки");
        loanApplication.setUpdated(LocalDateTime.now());
        facade.updateInfo(loanApplication);
        this.loanApplication = loanApplication;

    }

    public LoanApplication getLoanApplication(){
        //todo возможно тут стоит передать какие-то дополнительные параметры для логгирования
        System.out.println("Произвожу выдачу кредитной заявки");
        facade.updateInfo(loanApplication);
        return this.loanApplication;
    }
}
