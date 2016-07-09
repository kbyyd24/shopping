package cn.gaoyuexiang.service;

import cn.gaoyuexiang.model.PaymentRequest;
import cn.gaoyuexiang.model.PaymentResult;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PaymentServiceTest {
	@Mock
	private ItemService itemService;
	@Mock
	private OnSaleService onSaleService;
	private PaymentService paymentService;

	@Before
	public void setUp() throws Exception {
		paymentService = new PaymentService(new PaymentMapper(itemService, onSaleService));
	}

	@Test
	@Ignore
	public void payment() throws Exception {
		// TODO: 16-7-9 test the method
		PaymentRequest paymentRequest = new PaymentRequest();

		PaymentResult result = paymentService.payment(paymentRequest);

	}

}