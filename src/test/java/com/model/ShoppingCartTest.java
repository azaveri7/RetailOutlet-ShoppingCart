package com.model;

import org.junit.Assert;
import org.junit.Test;

public class ShoppingCartTest {

	@Test
	public void shouldIgnoreInvalidProducts() {
		ShoppingCart cart = new ShoppingCart();
		Product product1 = new Product("TV", 5000.0);
		Product product2 = new Product(null, 5000.0);
		Product product3 = new Product("TV", -5000.0);
		cart.addProduct(product1);
		cart.addProduct(product2);
		cart.addProduct(product3);
		Assert.assertEquals(5000.0, cart.getBillAmount(), 0);
	}

	@Test
	public void shouldReturnBillAmountForRegularCustomer() {
		ShoppingCart cart = new ShoppingCart();
		Product product1 = new Product("TV", 5000.0);
		cart.addProduct(product1);
		Assert.assertEquals(5000.0, cart.getBillAmount(), 0);
	}

	@Test
	public void shouldReturnBillAmountWithDiscountForRegularCustomer() {
		ShoppingCart cart = new ShoppingCart();
		Product product1 = new Product("TV", 5000.0);
		Product product2 = new Product("Refrigerator", 5000.0);
		cart.addProduct(product1);
		cart.addProduct(product2);
		Assert.assertEquals(9500.0, cart.getBillAmount(), 0);
	}

	@Test
	public void shouldReturnBillAmountWithHighDiscountForRegularCustomer() {
		ShoppingCart cart = new ShoppingCart();
		Product product1 = new Product("TV", 5000.0);
		Product product2 = new Product("Refrigerator", 10000.0);
		cart.addProduct(product1);
		cart.addProduct(product2);
		Assert.assertEquals(13500.0, cart.getBillAmount(), 0);
	}

	@Test
	public void shouldReturnBillAmountForPremiumCustomer() {
		ShoppingCart cart = new ShoppingCart();
		Product product1 = new Product("TV", 4000.0);
		cart.addProduct(product1);
		cart.setCustomerType(CustomerType.PREMIUM);
		Assert.assertEquals(3600.0, cart.getBillAmount(), 0);
	}

	@Test
	public void shouldReturnBillAmountWithDiscountForPremiumCustomer() {
		ShoppingCart cart = new ShoppingCart();
		Product product1 = new Product("TV", 5000.0);
		Product product2 = new Product("Refrigerator", 3000.0);
		cart.addProduct(product1);
		cart.addProduct(product2);
		cart.setCustomerType(CustomerType.PREMIUM);
		Assert.assertEquals(7000.0, cart.getBillAmount(), 0);
	}

	@Test
	public void shouldReturnBillAmountWithHighDiscountForPremiumCustomer() {
		ShoppingCart cart = new ShoppingCart();
		Product product1 = new Product("TV", 10000.0);
		Product product2 = new Product("Refrigerator", 2000.0);
		cart.addProduct(product1);
		cart.addProduct(product2);
		cart.setCustomerType(CustomerType.PREMIUM);
		Assert.assertEquals(10200.0, cart.getBillAmount(), 0);
	}

	@Test
	public void shouldReturnBillAmountWithHighestDiscountForPremiumCustomer() {
		ShoppingCart cart = new ShoppingCart();
		Product product1 = new Product("TV", 10000.0);
		Product product2 = new Product("Refrigerator", 10000.0);
		cart.addProduct(product1);
		cart.addProduct(product2);
		cart.setCustomerType(CustomerType.PREMIUM);
		Assert.assertEquals(15800.0, cart.getBillAmount(), 0);
	}

}
