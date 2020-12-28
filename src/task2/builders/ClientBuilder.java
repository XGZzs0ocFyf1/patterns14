package task2.builders;

import task2.model.Client;
import task2.model.CreditHistoryPart;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class ClientBuilder extends AbstractClientBuilder{

    public void setId(UUID id) {
        this.id = id;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setBirthDate(LocalDate birthDate){this.birthDate = birthDate;}

    public void setPersonalIdentifications(String personalIdentifications) {
        this.personalIdentifications = personalIdentifications;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public void setAverageIncomePerMonth(BigDecimal averageIncomePerMonth) {
        this.averageIncomePerMonth = averageIncomePerMonth;
    }

    public void setLastPlaceWorkExperience(String lastPlaceWorkExperience) {
        this.lastPlaceWorkExperience = lastPlaceWorkExperience;
    }

    public void setCreditHistory(List<CreditHistoryPart> creditHistory) {
        this.creditHistory = creditHistory;
    }

    public Client build(){
        return new Client(
                UUID.randomUUID(),
                fname,
                lname,
                birthDate,
                personalIdentifications,
                address,
                job,
                averageIncomePerMonth,
                lastPlaceWorkExperience,
                creditHistory);
    }


}
