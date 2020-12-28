package task3;

import java.util.UUID;

public class SenderService {

    private String URL = getUrl();

    private String getUrl(){
        StringBuilder sb  = new StringBuilder();
        sb.append("www.webservice.ru/clients/public/");
        sb.append(UUID.randomUUID());
        sb.append("/loan-application/1");

      return sb.toString();
    }


    public void sendEmail(){
        System.out.println("Sending email to client "+ URL);

    }

    public void sendSMS(){
        System.out.println("Sending SMS to client "+URL);

    }

    public static void main(String[] args) {
        SenderService service = new SenderService();
        service.sendEmail();
    }

}
