package cn.gaoyuexiang.service;

import cn.gaoyuexiang.model.PaymentItem;
import cn.gaoyuexiang.model.PaymentRequest;
import cn.gaoyuexiang.model.PaymentResult;
import cn.gaoyuexiang.service.sale.FullOff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {
	private final PaymentMapper paymentMapper;

	@Autowired
	public PaymentService(PaymentMapper paymentMapper) {
		this.paymentMapper = paymentMapper;
	}

	public PaymentResult payment(PaymentRequest paymentRequest) {
		List<PaymentItem> paymentItems = paymentMapper.map(paymentRequest);
		return new FullOff().calculate(paymentItems);

	}

}
