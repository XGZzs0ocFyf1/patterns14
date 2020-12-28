package task2.builders;

import task2.model.CreditHistoryPart;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class AbstractClientBuilder {

    protected UUID id;
    protected String fname;
    protected String lname;
    protected LocalDate birthDate;
    protected String personalIdentifications;
    protected String address;
    protected String job;
    protected BigDecimal averageIncomePerMonth;
    protected String lastPlaceWorkExperience;
    protected List<CreditHistoryPart> creditHistory = new ArrayList<>();
}
