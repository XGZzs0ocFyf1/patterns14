package task2.verificators;

import task2.model.LoanApplication;
import task2.model.Stage;

public interface Verifier {


     void setNextVerifier(Verifier verifier);
     void checkLoan(LoanApplication loanApplication, Stage stage);
     void printMessage();
     void verify(LoanApplication loanApplication);

}
