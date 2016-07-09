package cn.gaoyuexiang.controller;

import cn.gaoyuexiang.model.PaymentRequest;
import cn.gaoyuexiang.model.PaymentResult;
import cn.gaoyuexiang.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by melo on 16-7-8.
 */
@RestController
@RequestMapping("/payment")
public class PaymentController {
	private final CartService cartService;

	@Autowired
	public PaymentController(CartService cartService) {
		this.cartService = cartService;
	}

	@RequestMapping(method = POST)
	public PaymentResult payment(@RequestBody PaymentRequest paymentRequest) {

		return null;
	}
}
