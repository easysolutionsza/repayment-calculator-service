package org.toroue.repayment.calculator.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.toroue.repayment.calculator.model.QuoteRequest;
import org.toroue.repayment.calculator.service.RepaymentCalculatorService;

@RestController
@RequestMapping("/api/v1")
@Slf4j
public class RepaymentsController {



    @Autowired
    RepaymentCalculatorService  repaymentCalculatorService;
    @GetMapping ("/getAllQuotes")
    public ResponseEntity<?>getAllQuotes() {

        log.info("Inside calculateRepayAmount---------");
        return ResponseEntity.ok(repaymentCalculatorService.getAllQuotes());
    }

    @GetMapping ("/repayAmountApprox")

    public ResponseEntity<?> calculateRepayAmountApprox(@RequestBody QuoteRequest request) {

        log.info("Inside calculateRepayAmount---------");
        return ResponseEntity.ok(repaymentCalculatorService.calculateApproxPayment(request));
    }



    @GetMapping ("/repayAmountFull")

    public ResponseEntity<?> calculateRepayAmountFull(@RequestBody QuoteRequest request) {

        log.info("Inside calculateRepayAmount---------");
        return ResponseEntity.ok(repaymentCalculatorService.calculateFullPayment(request));
    }



    @PostMapping ("/addQuote")

    public ResponseEntity<?> saveQuote(@RequestBody QuoteRequest request) {
        log.info("Inside saveQuote---------");
        return ResponseEntity.ok(repaymentCalculatorService.addQuote(request));
    }



}