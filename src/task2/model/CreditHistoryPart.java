package task2.model;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * Client credit history fragment
 */
public class CreditHistoryPart {


    private UUID historyId;
    private String creditGoal;
    private BigDecimal creditAmount;


    public CreditHistoryPart(String creditGoal, BigDecimal creditAmount) {

        //imitate getting id: hibernate or etc @Generated stuff
        this.historyId = UUID.randomUUID();

        this.creditGoal = creditGoal;
        this.creditAmount = creditAmount;
    }

    public String getCreditGoal() {
        return creditGoal;
    }

    public BigDecimal getCreditAmount() {
        return creditAmount;
    }

    @Override
    public String toString() {
        return "\n CreditHistoryPart{" +
                "\n historyId=" + historyId +
                ", creditGoal='" + creditGoal + '\'' +
                ", creditAmount=" + creditAmount +
                "\n}" ;
    }
}
