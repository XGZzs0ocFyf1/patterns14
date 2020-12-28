package task2.verificators;

import task2.builders.ClientBuilderPipes;
import task2.model.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

/**
 * Verificator for LoanApplication.
 * It works like field validator
 * checking only that field is not null and not empty if fild has String type;
 * for BigDecimal LoanApplicationVerificator also cheched that amount is not
 * equal BigDecimal(0).
 * for int value checks that int is > 0
 */
public class LoanApplicationVerifier extends AbstractVerifier {


    public LoanApplicationVerifier(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void checkLoan(LoanApplication loanApplication, Stage previousStage) {
        if (stage.compareTo(previousStage) >= 0) verify(loanApplication);
        if(isVerify && nextVerifier != null) nextVerifier.checkLoan(loanApplication, previousStage);

    }

    public void verify(LoanApplication loanApplication){

        if (isClientDataValid(loanApplication.getClient())){
            isVerify = true;
        }else{
           message += " Клиент не прошел валидацию полей. ";
        }

        if (isVerify && isLoanConditionsValid(loanApplication.getLoanConditions())){
            isVerify = true;
        }else{
            isVerify = false;
            message += " Условия кредита не прошли валидацию полей";
        }

        message += " Первый этап проверки кредитной заявки ";
        message += isVerify ? "выполнен успешно." : " выявил нарушения заполнения полей.";
        printMessage();
    }

    private static boolean isLoanConditionsValid(LoanConditions loanConditions) {
      return isAmountNotValid(loanConditions.getMonthlyPayment())
              || isAmountNotValid(loanConditions.getLoanInterestRate())
              || loanConditions.getLoanPeriodInMonths() > 0;
    }

    private static boolean isAmountNotValid(BigDecimal amount) {
        return Objects.isNull(amount) || amount.signum() == 0 || amount.signum() == -1;
    }





    private boolean isClientDataValid(Client client) {
        String name = client.getFname();
        if (isStringEmpty(name)) return false;
        if (isStringEmpty(client.getLname())) return false;
        if (Objects.isNull(client.getBirthDate())) return false; //TODO: validate date
        if (isStringEmpty(client.getPersonalIdentifications())) return false;
        if (isStringEmpty(client.getAddress())) return false;
        if (isStringEmpty(client.getJob())) return false;
        if (isAmountNotValid(client.getAverageIncomePerMonth())) return false;
        if (isStringEmpty(client.getLastPlaceWorkExperience())) return false;
        // address

        List<CreditHistoryPart> history = client.getCreditHistory();
        for (CreditHistoryPart element : history) {
            if (isStringEmpty(element.getCreditGoal())) return false;
        }
        return true;
    }

    private static boolean isStringEmpty(String name) {
        return Objects.isNull(name) || name.equals("");
    }


    public static void main(String[] args) {
        BigDecimal part1LoanAmount = new BigDecimal(1_000_000);
        CreditHistoryPart part1 = new CreditHistoryPart("Chinese phones celling", part1LoanAmount);
        BigDecimal part2LoanAmount = new BigDecimal(2_000_000);
        CreditHistoryPart part2 = new CreditHistoryPart("Production expansion", part2LoanAmount);
        BigDecimal part3LoanAmount = new BigDecimal(10_000_000);
        CreditHistoryPart part3 = new CreditHistoryPart("domestic equipment development", part3LoanAmount);
        List<CreditHistoryPart> creditHistory = List.of(part1, part2, part3);

        ClientBuilderPipes builder = new ClientBuilderPipes();
        Client phoneTraider = builder.setFname("Василий")
                .setLname("Теркин")
                .setAddress("Мурманск, ул. Покорителей Ганимеда")
                .setPersonalIdentifications("M958 YLT42555 SP22456722123")
                .setJob("phone merchant")
                .setBirthDate(LocalDate.now())
                .setLastPlaceWorkExperience("12 months")
                .setAverageIncomePerMonth(new BigDecimal(100_000))
                .setCreditHistory(creditHistory)
                .build();

        System.out.println(phoneTraider);

        LoanApplicationVerifier verificator = new LoanApplicationVerifier(Stage.VERIFICATION);
        verificator.checkLoan(new LoanApplication(phoneTraider,
                new LoanConditions(new BigDecimal(0.11), 10, new BigDecimal(10_000))), Stage.VERIFICATION);


        BigDecimal b1 = new BigDecimal(0);
        BigDecimal b2 = new BigDecimal(2);


        System.out.println(b1.equals(b2));
        System.out.println(b1 == b2);

        System.out.println("Validating BigDecimal");
        System.out.println(new BigDecimal(0) + " не валидно? " + isAmountNotValid(new BigDecimal(0)));
        System.out.println(new BigDecimal(-1) + " не валидно? " + isAmountNotValid(new BigDecimal(-1)));
        System.out.println(new BigDecimal(2) + " не валидно? " + isAmountNotValid(new BigDecimal(2)));

        System.out.println();


        System.out.println("Validating Loan conditions");
        LoanConditions lc = new LoanConditions(new BigDecimal(0.11), 10, new BigDecimal(10_000));
        System.out.println(lc);
        System.out.println("is valid? "+isLoanConditionsValid(lc));

    }
}
