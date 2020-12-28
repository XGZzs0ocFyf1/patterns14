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
        LoanApplication loanApplication = service.createLoanApplication();

        Thread.sleep(3000);
        System.out.println();

        service.updateLoanApplication(loanApplication);

        System.out.println();
        loanApplication = service.getLoanApplication();
        System.out.println(loanApplication);


    }
}
