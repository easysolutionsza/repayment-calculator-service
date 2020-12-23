package org.toroue.repayment.calculator;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.toroue.repayment.calculator.controller.RepaymentsController;
import org.toroue.repayment.calculator.repository.DataRepository;
import org.toroue.repayment.calculator.service.RepaymentCalculatorService;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = RepaymentCalculatorServiceApplication.class)

class RepaymentCalculatorServiceApplicationTests {

	//@Test
	@Autowired
	private RepaymentCalculatorService repaymentCalculatorService;
	@Autowired
	@MockBean
	private RepaymentsController repaymentsController;


	@Autowired
	MockMvc mockMvc;
	@MockBean
	private DataRepository dataRepository;
	@Test

	void contextLoads() {
	}

}
