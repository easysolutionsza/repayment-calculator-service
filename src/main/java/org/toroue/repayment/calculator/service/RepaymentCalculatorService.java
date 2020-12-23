package org.toroue.repayment.calculator.service;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.toroue.repayment.calculator.model.QuoteRequest;
import org.toroue.repayment.calculator.model.QuoteResponse;
import org.toroue.repayment.calculator.model.entity.Quote;
import org.toroue.repayment.calculator.repository.DataRepository;
import org.toroue.repayment.calculator.utils.ObjectMapperUtils;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RepaymentCalculatorService {

    final DataRepository repository;

    public List<QuoteResponse> getAllQuotes()
    {
        return ObjectMapperUtils.mapAll(repository.findAll(),QuoteResponse.class);
    }


   public Double  calculateApproxPayment(QuoteRequest repaymentFactors){
       Double loanAmount=repaymentFactors.getLoanAmount();
       Integer term=repaymentFactors.getTerm();
       Double residualValue=repaymentFactors.getResidualValueRV();
       Double annualInterestRate=repaymentFactors.getAnnualInterestRate();
       Double monthlyInterest= annualInterestRate/1200;
       Double approxPayment=
               ((loanAmount + residualValue) / 2 * monthlyInterest * term + (loanAmount -residualValue)) /term;

       return approxPayment;

    }

   public Double calculateFullPayment(QuoteRequest repaymentFactors)
   {
       Double loanAmount=repaymentFactors.getLoanAmount();
       Integer term=repaymentFactors.getTerm();
       Double residualValue=repaymentFactors.getResidualValueRV();
       Double annualInterestRate=repaymentFactors.getAnnualInterestRate();
       Double monthlyInterest= annualInterestRate/1200;
       Double fullPayment=(loanAmount-(residualValue/Math.pow(1+ monthlyInterest,term)))*(monthlyInterest/(1-(1/(Math.pow(1+ monthlyInterest,term)))));
       return fullPayment;
   }

    public QuoteResponse addQuote(QuoteRequest request)
    {
        Quote quote = new Quote();
        QuoteResponse response = new QuoteResponse();
        BeanUtils.copyProperties(request, quote);
        quote.setFullPayment(calculateFullPayment(request));
        quote.setApproxPayment(calculateApproxPayment(request));
        quote=repository.save(quote);
        BeanUtils.copyProperties(quote, response);
        return response;
    }



}

