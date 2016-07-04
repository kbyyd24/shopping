package cn.gaoyuexiang.controller;

import cn.gaoyuexiang.model.OnSaleMsg;
import cn.gaoyuexiang.service.OnSaleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by melo on 16-7-5.
 */
@RestController
@RequestMapping(value = "/onSale")
public class OnSaleController {

	private OnSaleService onSaleService;

	public OnSaleController(OnSaleService onSaleService) {
		this.onSaleService = onSaleService;
	}

	public List<OnSaleMsg> sendMsg() {
		return onSaleService.loadMsg();
	}
}
