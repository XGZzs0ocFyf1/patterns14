package task3;

public class EmailAndSmsSender extends EmailSender implements Command{
    private SenderService service;

    public EmailAndSmsSender(SenderService service) {
        super(service);
        this.service = service;
    }

    @Override
    public void sendMessage() {
        service.sendSMS();
        super.sendMessage();


    }
}
