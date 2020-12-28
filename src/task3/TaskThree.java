package task3;


/***
 * Задание №3. Необходимо реализовать сервис отправки уведомлений клиенту для
 * ознакомления с анкетой (например, pdf файл) по кредиту. Существует 3 режима
 * уведомления:
 * 1. По sms – клиент получает sms сообщение, которое содержит ссылку для
 * скачивания анкеты;
 * 2. По email – клиент получает email сообщение c анкетой, а также sms сообщение с
 * оповещением, что пришел email;
 * 3. По sms и email – данный режим включает 1 и 2 режим (в итоге получается два sms
 * сообщения и одно email сообщение).
 * Примечание: Рекомендуется обратить внимание на шаблон проектирования «Команда»,
 * как один из возможных элементов реализации.
 */
public class TaskThree {

    public static void main(String[] args) {
        SenderService service = new SenderService();
        MessageSender messageSender = new MessageSender(new SmsSender(service), new EmailSender(service), new EmailAndSmsSender(service));

        messageSender.sendSms();
        messageSender.setSendEmail();
        messageSender.setSendEmailAndSms();
    }

}
