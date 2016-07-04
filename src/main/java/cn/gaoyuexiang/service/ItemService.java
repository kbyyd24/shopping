package cn.gaoyuexiang.service;

import cn.gaoyuexiang.model.Item;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService {
	public List<Item> getItems() {

		ArrayList<Item> items = new ArrayList<>(10);
		InputStream itemsStream = getClass().getResourceAsStream("/items.json");
		File itemsFile = new File("/items.json");
		try {
			ObjectMapper objMapper = new ObjectMapper();
			JsonNode jsonNode = objMapper.readTree(itemsStream);
			for (JsonNode aJsonNode : jsonNode) {
				Item item = objMapper.readValue(aJsonNode.toString(), Item.class);
				items.add(item);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return items;
	}
}
