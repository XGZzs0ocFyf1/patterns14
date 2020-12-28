package task2.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

/**
 * Класс имитация Entity типа. Хранит данные клиента банка
 * personalIdentifications - серия и номер паспорта
 * lastPlaceWorkExperience - опыт на последнем месте работы
 * creditHistory - список кредитная история
 */
public class Client {

    private final UUID id;
    private final String fname;
    private final String lname;
    private final LocalDate birthDate;
    private final String personalIdentifications;
    private final String address;
    private final String job;
    private final BigDecimal averageIncomePerMonth;
    private final String lastPlaceWorkExperience;
    List<CreditHistoryPart> creditHistory;


    public Client(UUID id,
                  String fname,
                  String lname,
                  LocalDate birthDate,
                  String personalIdentifications,
                  String address,
                  String job,
                  BigDecimal averageIncomePerMonth,
                  String lastPlaceWorkExperience,
                  List<CreditHistoryPart> creditHistory) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.birthDate = birthDate;
        this.personalIdentifications = personalIdentifications;
        this.address = address;
        this.job = job;
        this.averageIncomePerMonth = averageIncomePerMonth;
        this.lastPlaceWorkExperience = lastPlaceWorkExperience;
        this.creditHistory = creditHistory;
    }


    public UUID getId() {
        return id;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getPersonalIdentifications() {
        return personalIdentifications;
    }

    public String getAddress() {
        return address;
    }

    public String getJob() {
        return job;
    }

    public BigDecimal getAverageIncomePerMonth() {
        return averageIncomePerMonth;
    }

    public String getLastPlaceWorkExperience() {
        return lastPlaceWorkExperience;
    }

    public List<CreditHistoryPart> getCreditHistory() {
        return creditHistory;
    }

    @Override
    public String toString() {
        String nl = "\n";
        return "Client{" +
                "\n id=" + id +
                ",\n  fname='" + fname + '\'' +
                ",\n  lname='" + lname + '\'' +
                ",\n  birthDate=" + birthDate +
                ",\n  personalIdentifications='" + personalIdentifications + '\'' +
                ",\n  address='" + address + '\'' +
                ",\n  job='" + job + '\'' +
                ",\n  averageIncomePerMonth=" + averageIncomePerMonth +
                ",\n  lastPlaceWorkExperience='" + lastPlaceWorkExperience + '\'' +
                ",\n  creditHistory=" + creditHistory +
                "\n }";
    }
}
