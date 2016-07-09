package cn.gaoyuexiang.model;

import com.google.common.collect.Lists;

import java.util.List;

public class PaymentResult {

	private List<ResultItem> resultItems = Lists.newArrayList();
	private NoSaleResult noSaleResult = new NoSaleResult();
	private double sale;
	private double total;


	public void addResultItem(ResultItem item) {
		resultItems.add(item);
	}

	public void addNoSaleItem(NoSaleItem item) {
		noSaleResult.addItem(item);
	}


	public List<ResultItem> getResultItems() {
		return resultItems;
	}

	public NoSaleResult getNoSaleResult() {
		return noSaleResult;
	}

	public double getSale() {
		return sale;
	}

	public void setSale(double sale) {
		this.sale = sale;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
}
