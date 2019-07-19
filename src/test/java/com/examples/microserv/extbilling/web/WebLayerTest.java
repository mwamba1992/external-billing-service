package com.examples.microserv.extbilling.web;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessRequest;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessResponse;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;

import static org.springframework.restdocs.payload.PayloadDocumentation.requestFields;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;

import com.examples.microserv.extbilling.controller.BillCheckController;
import com.examples.microserv.extbilling.model.Bill;
import com.examples.microserv.extbilling.repository.BillRepository;
import com.examples.microserv.extbilling.service.BillService;

@RunWith(SpringRunner.class)
@WebMvcTest(BillCheckController.class)
@AutoConfigureRestDocs(outputDir = "target/snippets")
public class WebLayerTest {

	@Autowired
	MockMvc mockMvc;

	@MockBean
	BillRepository billRepository;
	
	@MockBean
	RestTemplate restTemplate;

	@Autowired
	BillService billService;
	

	@Before
	public void createOneTestBill() {
		
		System.out.println("###############");
		Bill bill = new Bill();
		bill.setBillAmount(new BigDecimal(1000));
		bill.setBillControlNumber("99121212");
		bill.setCustomerEmail("jo@gmail.com");
		bill.setId("2121");
		bill.setExpirationDate(new Date());
		bill.setReceiveDate(new Date());

		billService.createBill(bill);

	}

	@Test
	public void testBillCheckEndPoint() throws Exception {

		String reqBody = "{\"billCheckId\":\"2121\", \"controlNumber\":\"99121212\", \"spCode\":\"SP481\"}";

		mockMvc.perform(
				post("/extbills/search").contentType(MediaType.APPLICATION_JSON).content(reqBody))
				.andDo(print()).andExpect(status().isOk())
				.andDo(document("bill-search", preprocessRequest(prettyPrint()), preprocessResponse(prettyPrint()),
						requestFields(fieldWithPath("billCheckId").description("Bill Check Request Id"),
								fieldWithPath("controlNumber").description("Bill Control Number"),
								fieldWithPath("spCode").description("Bill SpCode")),
						responseFields(fieldWithPath("billControlNumber").description("Bill Check Request Id"),
								fieldWithPath("billAmount").description("Bill Amount"),
								fieldWithPath("customerEmail").description("Payer Email"),
								fieldWithPath("stsCode").description("Bill Check Statatus code"),
								fieldWithPath("billId").description("Bill Id"),
								fieldWithPath("expirationDate").description("Bill Expiry date"),
								fieldWithPath("serviceId").description("Service Id"),
								fieldWithPath("receiveDate").description("Bill Receive Date"),
								fieldWithPath("currencyId").description("Bill Currency")
								
								)
						
						
						));
	}

}
