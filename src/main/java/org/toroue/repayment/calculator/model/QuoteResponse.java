package org.toroue.repayment.calculator.model;

import lombok.Data;



@Data

public class QuoteResponse {
    private Integer term = 36;
    private Double loanAmount = 100000.00;
    private Double annualInterestRate = 10.00;
    private Double residualValueRV = 0.00;
    private Double approxPayment = 0.00;
    private Double fullPayment = 0.00;
}
