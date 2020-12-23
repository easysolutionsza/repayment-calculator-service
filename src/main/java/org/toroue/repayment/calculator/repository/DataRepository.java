package org.toroue.repayment.calculator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.toroue.repayment.calculator.model.QuoteResponse;
import org.toroue.repayment.calculator.model.entity.Quote;

public interface DataRepository extends JpaRepository<Quote, Long> {
}
