package task3;

public class EmailSender implements Command{
    private SenderService service;

    public EmailSender(SenderService service) {
        this.service = service;
    }

    @Override
    public void sendMessage() {
        service.sendSMS();
        service.sendEmail();
    }
}
