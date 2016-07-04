package cn.gaoyuexiang.model;

import java.util.List;

/**
 * Created by melo on 16-7-5.
 */
public class OnSaleMsg {
	private String type;
	private List<String> barcodes;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<String> getBarcodes() {
		return barcodes;
	}

	public void setBarcodes(List<String> barcodes) {
		this.barcodes = barcodes;
	}
}
