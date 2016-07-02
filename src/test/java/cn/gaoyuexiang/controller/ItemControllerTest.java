package cn.gaoyuexiang.controller;

import cn.gaoyuexiang.model.Item;
import cn.gaoyuexiang.service.ItemService;
import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ItemControllerTest {

	private ItemController itemController;
	@Mock
	private ItemService itemService;

	@Before
	public void setUp() throws Exception {
		itemController = new ItemController(itemService);
	}

	@Test
	public void should_get_all_item_lists() throws Exception {
		//given
		List<Item> items = Lists.newArrayList(new Item());
		when(itemService.getItems()).thenReturn(items);

		//when
		List<Item> result = itemController.getItems();

		//then
		assertThat(result, is(items));
	}
}