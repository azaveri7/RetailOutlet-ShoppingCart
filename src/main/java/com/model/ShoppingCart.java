package com.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

import com.util.BillCalculator;

public class ShoppingCart {

	private List<Product> productList = new ArrayList<>();
	private double billAmount;
	private CustomerType customerType = CustomerType.REGULAR;

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	public void setBillAmount(double billAmount) {
		this.billAmount = billAmount;
	}

	public CustomerType getCustomerType() {
		return customerType;
	}

	public void setCustomerType(CustomerType customerType) {
		this.customerType = customerType;
	}

	public double getBillAmount() {
		double amount = productList.stream().filter(isValidProduct()).mapToDouble(product -> product.getPrice()).sum();
		billAmount = BillCalculator.calculateBill(amount, customerType);
		return billAmount;
	}

	public void addProduct(Product product) {
		productList.add(product);
	}

	private static Predicate<Product> isValidProduct() {
		return product -> (product.getPrice() > 0 && Objects.nonNull(product.getName()));
	}

}
