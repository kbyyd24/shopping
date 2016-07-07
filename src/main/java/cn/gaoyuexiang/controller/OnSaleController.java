package cn.gaoyuexiang.controller;

import cn.gaoyuexiang.model.OnSaleMsg;
import cn.gaoyuexiang.service.OnSaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by melo on 16-7-5.
 */
@RestController
@RequestMapping("/rules")
public class OnSaleController {

	private OnSaleService onSaleService;

	@Autowired
	public OnSaleController(OnSaleService onSaleService) {
		this.onSaleService = onSaleService;
	}

	@RequestMapping( method = GET)
	@CrossOrigin
	public List<OnSaleMsg> sendMsg() {
		return onSaleService.loadMsg();
	}
}
