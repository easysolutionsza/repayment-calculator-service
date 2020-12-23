package org.toroue.repayment.calculator.model.entity;


import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "quote")
public class Quote {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private Integer term = 36;
    private Double loanAmount = 100000.00;
    private Double annualInterestRate = 10.00;
    private Double residualValueRV = 0.00;
    private Double approxPayment = 0.00;
    private Double fullPayment = 0.00;

}
