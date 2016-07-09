package cn.gaoyuexiang.model;

import com.google.common.collect.Lists;

import java.util.List;

public class NoSaleResult {
	private List<NoSaleItem> noSaleItems = Lists.newArrayList();
	private double sum;
	private double sale;


	void addItem(NoSaleItem item) {
		noSaleItems.add(item);
	}

	public List<NoSaleItem> getNoSaleItems() {
		return noSaleItems;
	}

	public void setNoSaleItems(List<NoSaleItem> noSaleItems) {
		this.noSaleItems = noSaleItems;
	}

	public double getSum() {
		return sum;
	}

	public void setSum(double sum) {
		this.sum = sum;
	}

	public double getSale() {
		return sale;
	}

	public void setSale(double sale) {
		this.sale = sale;
	}
}
