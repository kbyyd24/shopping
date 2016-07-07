package cn.gaoyuexiang.model;

import java.util.List;

/**
 * Created by melo on 16-7-5.
 */
public class OnSaleMsg {
	private int type;
	private String name;
	private List<String> barcodes;

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getBarcodes() {
		return barcodes;
	}

	public void setBarcodes(List<String> barcodes) {
		this.barcodes = barcodes;
	}
}
