package cn.gaoyuexiang.model;

public class ResultItem {

	private String name;
	private double price;
	private String unit;
	private int amount;

	public ResultItem(Item item, int amount) {
		this.name = item.getName();
		this.price = item.getPrice();
		this.unit = item.getUnit();
		this.amount = amount;
	}

	public String getName() {
		return name;
	}

	public int getAmount() {
		return amount;
	}

	public double getPrice() {
		return price;
	}

	public String getUnit() {
		return unit;
	}
}
