package com.model;

public class DiscountSlab {

	private double start;
	private double end;
	private double discount;

	public double getStart() {
		return start;
	}

	public void setStart(double start) {
		this.start = start;
	}

	public double getEnd() {
		return end;
	}

	public void setEnd(double end) {
		this.end = end;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public DiscountSlab(double start, double end, double discount) {
		super();
		this.start = start;
		this.end = end;
		this.discount = discount;
	}

}
