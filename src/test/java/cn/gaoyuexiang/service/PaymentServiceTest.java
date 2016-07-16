package cn.gaoyuexiang.service;

import cn.gaoyuexiang.model.PaymentItem;
import cn.gaoyuexiang.model.PaymentRequest;
import cn.gaoyuexiang.model.PaymentResult;
import cn.gaoyuexiang.service.sale.FullOff;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PaymentServiceTest {
	@Mock
	private PaymentMapper paymentMapper;

	private PaymentService paymentService;

	@Before
	public void setUp() throws Exception {
		paymentService = new PaymentService(paymentMapper);
	}

	@Test
	public void payment() throws Exception {
		PaymentRequest paymentRequest = new PaymentRequest();
		ArrayList<PaymentItem> paymentItems = new ArrayList<>();
		PaymentResult paymentResult = new PaymentResult();
		//only created by mock, can use when()
		FullOff fullOff = Mockito.mock(FullOff.class);
		when(paymentMapper.map(paymentRequest)).thenReturn(paymentItems);
		when(fullOff.calculate(paymentItems)).thenReturn(paymentResult);

		PaymentResult result = paymentService.payment(paymentRequest, fullOff);

		assertThat(result, is(paymentResult));

	}

}