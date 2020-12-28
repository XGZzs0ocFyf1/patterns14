package task2.builders;

import task2.model.Client;
import task2.model.CreditHistoryPart;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class   ClientBuilderPipes  extends  AbstractClientBuilder {

    public ClientBuilderPipes setFname(String fname) {
        this.fname = fname;
        return this;
    }

    public ClientBuilderPipes setLname(String lname) {
        this.lname = lname;
        return this;
    }

    public ClientBuilderPipes setBirthDate(LocalDate birthDate){
        this.birthDate = birthDate;
        return this;
    }


    public ClientBuilderPipes setPersonalIdentifications(String personalIdentifications) {
        this.personalIdentifications = personalIdentifications;
        return this;
    }

    public ClientBuilderPipes setAddress(String address) {
        this.address = address;
        return this;
    }

    public ClientBuilderPipes setJob(String job) {
        this.job = job;
        return this;
    }

    public ClientBuilderPipes setAverageIncomePerMonth(BigDecimal averageIncomePerMonth) {
        this.averageIncomePerMonth = averageIncomePerMonth;
        return this;
    }

    public ClientBuilderPipes setLastPlaceWorkExperience(String lastPlaceWorkExperience) {
        this.lastPlaceWorkExperience = lastPlaceWorkExperience;
        return this;
    }

    public ClientBuilderPipes setCreditHistory(List<CreditHistoryPart> creditHistory) {
        this.creditHistory = creditHistory;
        return this;
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
