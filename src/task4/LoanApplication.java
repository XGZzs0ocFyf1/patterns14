package task4;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LoanApplication {

    private long id;
    private String content;
    private LocalDateTime created;
    private LocalDateTime updated;


    public LoanApplication(long id, String content) {
        this.created = LocalDateTime.now();
        this.updated = LocalDateTime.now();

        this.id = id;
        this.content = content;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:MM:ss dd.MM.yyyy");
        return "LoanApplication{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", created=" + formatter.format(created) +
                ", updated=" + formatter.format(updated) +
                '}';
    }
}
