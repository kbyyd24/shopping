package cn.gaoyuexiang.service.sale;

import cn.gaoyuexiang.model.*;

import java.util.List;

public class FullOff implements SaleStrategy {
	@Override
	public PaymentResult calculate(List<PaymentItem> items) {
		PaymentResult paymentResult = new PaymentResult();
		addToResult(items, paymentResult);

		int sale = (int) (paymentResult.getNoSaleSum()/ 100 * 10);
		paymentResult.setNoSaleSum(paymentResult.getNoSaleSum() - sale);
		paymentResult.setTotal(paymentResult.getTotal() - sale);
		paymentResult.setSale(sale);

		return paymentResult;
	}

	private void addToResult(List<PaymentItem> items, PaymentResult pResult) {
		for (PaymentItem paymentItem :
						items) {
			double price = paymentItem.getItem().getPrice();
			Item item = paymentItem.getItem();
			int amount = paymentItem.getAmount();
			pResult.setTotal(pResult.getTotal() + price * amount);
			pResult.addResultItem(new ResultItem(item, amount));
			judgeSale(pResult, paymentItem, item, amount);
		}
	}

	private void judgeSale(PaymentResult pResult, PaymentItem paymentItem, Item item, int amount) {
		if (paymentItem.getSaleInfo() != null && paymentItem.getSaleInfo().getType() == 1) {
			double sum = pResult.getNoSaleResult().getSum();
			sum += item.getPrice() * amount;
			pResult.setNoSaleSum(sum);
		} else {
			pResult.addNoSaleItem(new NoSaleItem(item.getName(),
							item.getPrice() * amount));
		}
	}
}
