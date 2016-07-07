package cn.gaoyuexiang.controller;

import cn.gaoyuexiang.model.Item;
import cn.gaoyuexiang.service.ItemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
//import javax.servlet.http.HttpServletResponse;
import java.util.List;
//import org.apache.struts2.ServletActionContext;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by melo on 16-7-2.
 * demo controller
 */

@RestController
@RequestMapping("/item")

public class ItemController {
	private ItemService itemService;
	@Autowired
	public ItemController(ItemService itemService) {
		this.itemService = itemService;
	}
	@ResponseBody
	@CrossOrigin
	@RequestMapping(method = GET)
	public List<Item> getItems() {
		return itemService.getItems();
	}
}