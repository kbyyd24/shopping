package cn.gaoyuexiang.service;

import cn.gaoyuexiang.model.*;
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
		PaymentResult paymentResult = new PaymentResult();
		double saleTotal = 0;
		double total = 0;

		for (PaymentItem paymentItem :
						paymentItems) {
			String name = paymentItem.getItem().getName();
			double price = paymentItem.getItem().getPrice();
			String unit = paymentItem.getItem().getUnit();
			int amount = paymentItem.getAmount();

			total += price * amount;

			// TODO: 16-7-9 use Item
			paymentResult.addResultItem(new ResultItem(name, price, unit, amount));
			if (paymentItem.getSaleInfo() != null && paymentItem.getSaleInfo().getType() == 1) {
				saleTotal += price * amount;
			} else {
				paymentResult.addNoSaleItem(new NoSaleItem(name, price * amount));
			}

		}

		int sale = (int) saleTotal / 100 * 10;
		saleTotal -= sale;
		total -= sale;

		paymentResult.getNoSaleResult().setSale(sale);
		paymentResult.getNoSaleResult().setSum(saleTotal);
		paymentResult.setSale(sale);
		paymentResult.setTotal(total);

		return paymentResult;
	}

}
