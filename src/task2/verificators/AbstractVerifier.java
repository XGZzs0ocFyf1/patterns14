package task2.verificators;

import task2.model.LoanApplication;
import task2.model.Stage;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class AbstractVerifier implements Verifier {

    protected Verifier nextVerifier;
    protected boolean isVerify = false;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy hh:mm:ss" );
    protected String message = formatter.format(LocalDateTime.now())+ " ";
    protected Stage stage;


    @Override
    public void setNextVerifier(Verifier verifier) {
        this.nextVerifier = verifier;
    }

    @Override
    public abstract void checkLoan(LoanApplication loanApplication, Stage previousStage);

    @Override
    public void printMessage() {
        System.out.println(message);
    }


    public abstract void verify(LoanApplication loanApplication);
}
