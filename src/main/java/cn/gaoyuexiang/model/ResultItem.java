package cn.gaoyuexiang.model;

public class ResultItem {

	private String name;
	private double price;
	private String unit;
	private final int amount;

	public ResultItem(String name, double price, String unit, int amount) {
		this.name = name;
		this.price = price;
		this.unit = unit;
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
