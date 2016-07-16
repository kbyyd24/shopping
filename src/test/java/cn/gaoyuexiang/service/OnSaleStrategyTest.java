package cn.gaoyuexiang.service;

import cn.gaoyuexiang.model.OnSaleInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring.xml"})
public class OnSaleServiceTest {

	@Autowired
	private OnSaleService service;

	@Test
	public void get_on_sale_msgs() throws Exception {
		List<OnSaleInfo> onSaleInfos = service.getSaleInfos();
		assertThat(onSaleInfos.size(), is(1));
		assertThat(onSaleInfos.get(0).getName(), is("满一百减十块"));
		assertThat(onSaleInfos.get(0).getBarcodes().get(0), is("ITEM00000"));
	}
}