package cn.gaoyuexiang.controller;

import cn.gaoyuexiang.model.PaymentRequest;
import cn.gaoyuexiang.model.PaymentResult;
import cn.gaoyuexiang.service.PaymentService;
import cn.gaoyuexiang.service.sale.FullOff;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PaymentControllerTest {

	@Mock
	private PaymentService paymentService;

	private PaymentController paymentController;

	@Before
	public void setUp() throws Exception {
		paymentController = new PaymentController(paymentService);
	}

	@Test
	public void should_add_item_into_cart() throws Exception {
		PaymentRequest request = new PaymentRequest();
		PaymentResult paymentResult = new PaymentResult();
		when(paymentService.payment(Mockito.eq(request), Mockito.any(FullOff.class))).thenReturn(paymentResult);

		PaymentResult result = paymentController.payment(request);

		assertThat(paymentResult, is(result));
	}
}