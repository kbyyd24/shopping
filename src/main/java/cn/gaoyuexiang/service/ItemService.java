package cn.gaoyuexiang.service;

import cn.gaoyuexiang.model.Item;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService {
	public List<Item> getItems() {
//		new ObjectMapper()
		ArrayList<Item> items = new ArrayList<>();
		items.add(new Item());
		return items;
	}
}
