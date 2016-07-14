package cn.gaoyuexiang.model;

public class PaymentItem {
	private Item item;
	private int amount;
	private OnSaleInfo saleInfo;

	public PaymentItem(Item item, int amount) {
		this.item = item;
		this.amount = amount;
	}

	public Item getItem() {
		return item;
	}

	public int getAmount() {
		return amount;
	}

	public void setSaleInfo(OnSaleInfo saleInfo) {
		this.saleInfo = saleInfo;
	}

	public OnSaleInfo getSaleInfo() {
		return saleInfo;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
}
