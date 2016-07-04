package cn.gaoyuexiang.controller;

import cn.gaoyuexiang.model.OnSaleMsg;
import cn.gaoyuexiang.service.OnSaleService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

/**
 * Created by melo on 16-7-5.
 */
@RunWith(MockitoJUnitRunner.class)
public class OnSaleControllerTest {

	private OnSaleController onSaleController;

	@Mock
	private OnSaleService onSaleService;

	@Before
	public void setUp() throws Exception {
		onSaleController = new OnSaleController(onSaleService);
	}

	@Test
	public void should_get_all_on_sale_msg() throws Exception {
		List<OnSaleMsg> msgs = new ArrayList<>();
		when(onSaleService.loadMsg()).thenReturn(msgs);

		List<OnSaleMsg> result = onSaleController.sendMsg();

		assertThat(result, is(msgs));
	}
}