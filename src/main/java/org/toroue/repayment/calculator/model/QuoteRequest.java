package org.toroue.repayment.calculator.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class QuoteRequest {

    private Integer term;
    private Double loanAmount;
    private Double annualInterestRate;
    private Double residualValueRV;

}
