package task3;

public class MessageSender {
    Command sendSms;
    Command sendEmail;
    Command sendEmailAndSms;

    public MessageSender(Command sendSms, Command sendEmail, Command sendEmailAndSms) {
        this.sendSms = sendSms;
        this.sendEmail = sendEmail;
        this.sendEmailAndSms = sendEmailAndSms;
    }


    public void sendSms(){
        System.out.println();
        sendSms.sendMessage();
    }

    public void setSendEmail(){
        System.out.println();
        sendEmail.sendMessage();
    }

    public void setSendEmailAndSms(){
        System.out.println();
        sendEmailAndSms.sendMessage();
    }
}
