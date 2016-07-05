package cn.gaoyuexiang.service;

import cn.gaoyuexiang.model.OnSaleMsg;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.hamcrest.Matchers.isA;
import static org.junit.Assert.assertThat;

/**
 * Created by melo on 16-7-5.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring.xml"})
public class OnSaleServiceTest {

	@Autowired
	private OnSaleService service;

	@Test
	public void get_on_sale_msgs() throws Exception {
		List<OnSaleMsg> onSaleMsgs = service.loadMsg();
		for (OnSaleMsg onSaleMsg : onSaleMsgs) {
			assertThat(onSaleMsg.getType(), isA(String.class));
		}
	}
}