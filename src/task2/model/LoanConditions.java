package task2.model;

import java.math.BigDecimal;


/**
 * Loan conditions for Client
 * LoanInterestRate - rate in domestic currency
 * loanPeriodInMonths - number of months of which loan will be took out
 */
public class LoanConditions {

    private BigDecimal loanInterestRate;
    private int loanPeriodInMonths;
    private BigDecimal monthlyPayment;


    public LoanConditions(BigDecimal loanInterestRate, int loanPeriodInMonths, BigDecimal monthlyPayment) {
        this.loanInterestRate = loanInterestRate;
        this.loanPeriodInMonths = loanPeriodInMonths;
        this.monthlyPayment = monthlyPayment;
    }

    public BigDecimal getLoanInterestRate() {
        return loanInterestRate;
    }

    public int getLoanPeriodInMonths() {
        return loanPeriodInMonths;
    }

    public BigDecimal getMonthlyPayment() {
        return monthlyPayment;
    }


    @Override
    public String toString() {
        return "LoanConditions{" +
                "loanInterestRate=" + loanInterestRate +
                ", loanPeriodInMonths=" + loanPeriodInMonths +
                ", monthlyPayment=" + monthlyPayment +
                '}';
    }
}
