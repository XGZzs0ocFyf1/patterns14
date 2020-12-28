package task3;

public class SmsSender implements Command {
    private SenderService service;

    public SmsSender(SenderService service) {
        this.service = service;
    }

    @Override
    public void sendMessage() {
        service.sendSMS();
    }
}
