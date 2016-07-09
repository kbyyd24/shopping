package cn.gaoyuexiang.service;

import cn.gaoyuexiang.model.Item;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.List;

@Service
public class ItemService {
	public static final String ITEM_DB = "/items.json";
	private final SerializableService serializableService;

	@Autowired
	public ItemService(SerializableService serializableService) {
		this.serializableService = serializableService;
	}

	public List<Item> getItems() {
		InputStream itemsStream = getClass().getResourceAsStream(ITEM_DB);
		return serializableService.convertTo(itemsStream, new TypeReference<List<Item>>() {
		});
	}

}
