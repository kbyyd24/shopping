package cn.gaoyuexiang.service;

import cn.gaoyuexiang.model.Item;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Created by melo on 16-7-5.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring.xml"})
public class ItemServiceTest {

	@Autowired
	private ItemService itemService;

	@Test
	public void get_items() throws Exception {
		itemService.getItems();
		List<Item> items = itemService.getItems();
		assertNotNull(items);
		assertNotEquals(items.size(), 0);
		assertThat(items.get(0).getBarcode(), is("ITEM00000"));
	}
}