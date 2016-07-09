package cn.gaoyuexiang.controller;

import cn.gaoyuexiang.model.PaymentResult;
import cn.gaoyuexiang.service.CartService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

/**
 * Created by melo on 16-7-8.
 */
@RunWith(MockitoJUnitRunner.class)
public class PaymentControllerTest {

	@Mock
	private CartService cartService;

	private PaymentController paymentController;

	@Before
	public void setUp() throws Exception {
		paymentController = new PaymentController(cartService);
	}

	@Test
	public void should_add_item_into_cart() throws Exception {
		List<String> items = new ArrayList<>();
		PaymentResult paymentResult = new PaymentResult();
		when(cartService.payment(items)).thenReturn(paymentResult);

		paymentController.payment(null);
	}
}