package task4;

import task4.services.LoanApplicationService;

/**
 * Facade pattern
 *
 * Существует сервис (HistoryService) для работы с кредитной заявкой c
 * методами создать, обновить, получить заявку. Однако существуют требования к
 * реализации продукта со стороны мониторинга (MonitoringService), аудита (AuditService),
 * журналирования (LogService). Необходимо перед и после вызова методов HistoryService
 * отправить событие/сообщение в выше перечисленные системы (мониторинг, аудит,
 * журналирование). Реализацию сервисов MonitoringService, AuditService, LogService
 * можно сделать максимально простыми, с методами, которые необходимы только вам.
 * Требуется применить структурный шаблон проектирования и реализовать сервис по
 * работе с кредитной заявкой (операции создать, обновить, получить), с перечисленными
 * требованиями к системе.
 */
public class TaskFour {

    public static void main(String[] args) throws InterruptedException {
        LoanApplicationService service = new LoanApplicationService();
        LoanApplication loanApplication1 = service.createLoanApplication();
        LoanApplication loanApplication2 = service.createLoanApplication();
        LoanApplication loanApplication3 = service.createLoanApplication();

        Thread.sleep(3000);
        System.out.println();

        service.updateLoanApplication(loanApplication1);
        service.updateLoanApplication(loanApplication2);
        service.updateLoanApplication(loanApplication3);

        //todo вот здесь вызывается то число, которое последним передали в сервис выше
        System.out.println();
        service.printApplications();





    }
}
