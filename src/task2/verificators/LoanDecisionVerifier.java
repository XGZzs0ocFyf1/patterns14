package task2.verificators;

import task2.model.LoanApplication;
import task2.model.Stage;

import java.util.concurrent.ThreadLocalRandom;


/**
 * This class imitates manager work, but because it is learning project
 * here I use random near 70% positive decision for loan applications
 */
public class LoanDecisionVerifier extends AbstractVerifier {


    public LoanDecisionVerifier(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void checkLoan(LoanApplication loanApplication, Stage previousStage) {

        if (stage.compareTo(previousStage) >= 0) verify(loanApplication);
        if (isVerify && nextVerifier != null) nextVerifier.checkLoan(loanApplication, previousStage);
    }



    @Override
    public void verify(LoanApplication loanApplication) {

        //loan manager work imitation
        boolean isValid = ThreadLocalRandom.current().nextInt(0, 10) > 2;
        message += " Кредитная заявка ";
        message += isValid ? "одобрена." : "отклонена.";
        printMessage();

    }
}
