package task2;

import task2.builders.ClientBuilderPipes;
import task2.model.*;
import task2.verificators.LoanAppComplVerifier;
import task2.verificators.LoanApplicationVerifier;
import task2.verificators.LoanDecisionVerifier;
import task2.verificators.Verifier;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/**
 * Задание №2. Реализовать процесс подачи кредитной заявки, который предполагает следующие шаги:
 * Шаг №1. Проверить заявку (объект кредитной заявки) на полноту заполнения данными.
 * Минимальный состав заявки включает информацию о клиенте (ФИО, персональные
 * данные, данные о доходе, кредитная история и так далее), условиях кредита (процентная
 * ставка, срок, ежемесячный платеж) и т.д.
 * Шаг №2. Комплаенс проверка клиента.
 * Шаг №3. Принять решение по кредитной заявке (одобрить или отклонить в выдаче
 * кредита).
 * Каждый шаг подразумевает успешное или неуспешное выполнение. Если успешно, то
 * выполняется следующий шаг, иначе процесс завершается. Необходимо придумать,
 * условия успешного и неуспешного выполнения шагов.
 * Примечание: Рекомендуется обратить внимание на поведенческие шаблоны
 * проектирования.
 */


/*
output
28.12.2020 05:43:09 Первый этап проверки кредитной заявки выполнен успешно.
28.12.2020 05:43:09 Комплаенс проверка выполнена успешно.
28.12.2020 05:43:09  Кредитная заявка одобрена.

if set this no null in builder
// .setJob("phone merchant")

we get error message at step1 and do not pass through other stages
28.12.2020 05:54:24  Клиент не прошел валидацию полей.  Условия кредита не прошли валидацию полей Первый этап проверки кредитной заявки  выявил нарушения заполнения полей.


 */
public class TaskTwo {

    //generate mock client template
    public Client createClient() {

        CreditHistoryPart part1 = new CreditHistoryPart("Chinese phones celling", new BigDecimal(1_000_000));
        CreditHistoryPart part2 = new CreditHistoryPart("Production expansion", new BigDecimal(2_000_000));
        CreditHistoryPart part3 = new CreditHistoryPart("domestic equipment development", new BigDecimal(10_000_000));
        List<CreditHistoryPart> creditHistory = List.of(part1, part2, part3);


        Client phoneTraider = new ClientBuilderPipes()
                .setFname("Василий")
                .setLname("Теркин")
                .setAddress("Мурманск, ул. Покорителей Ганимеда")
                .setPersonalIdentifications("M958 YLT42555 SP22456722123")
                .setJob("phone merchant")
                .setBirthDate(LocalDate.now())
                .setLastPlaceWorkExperience("12 months")
                .setAverageIncomePerMonth(new BigDecimal(100_000))
                .setCreditHistory(creditHistory)
                .build();

        return phoneTraider;
    }

    public static void main(String[] args) {
        TaskTwo t2 = new TaskTwo();
        Client client = t2.createClient();
        LoanApplication loanApplication = new LoanApplication(client,
                new LoanConditions(new BigDecimal(0.11),20, new BigDecimal(500_000)));


        Verifier fieldsVerifier = new LoanApplicationVerifier(Stage.VERIFICATION);
        Verifier loanComplienceVerifier = new LoanAppComplVerifier(Stage.COMPLIANCE);
        Verifier loanDecisionVerifier = new LoanDecisionVerifier(Stage.DECISION);

        fieldsVerifier.setNextVerifier(loanComplienceVerifier);
        loanComplienceVerifier.setNextVerifier(loanDecisionVerifier);
        fieldsVerifier.checkLoan(loanApplication, Stage.VERIFICATION );


    }

}
