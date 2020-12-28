package task2.verificators;


import task2.model.LoanApplication;
import task2.model.Stage;

import java.util.concurrent.ThreadLocalRandom;

/**
 * поскольку мы не знаем, как будет работать логика
 * то разрешение на выдачу оформим в виде типового ГСЧ
 * todo возможно придумать что-то новое
 */
public class LoanAppComplVerifier extends AbstractVerifier {


    public LoanAppComplVerifier(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void checkLoan(LoanApplication loanApplication, Stage previousStage) {

        if (stage.compareTo(previousStage) >= 0) {
            if (stage.compareTo(previousStage) >= 0) verify(loanApplication);
            if (isVerify && nextVerifier != null) nextVerifier.checkLoan(loanApplication, previousStage);
        }

    }


    @Override
    public void verify(LoanApplication loanApplication) {
        isVerify = ThreadLocalRandom.current().nextInt(0, 10) > 2;
        message += "Комплаенс проверка ";
        message += isVerify ? "выполнена успешно." : " выявила нарушения.";
        printMessage();
    }


}
