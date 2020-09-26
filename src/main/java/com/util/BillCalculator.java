package com.util;

import java.util.List;

import com.model.CustomerType;
import com.model.DiscountSlab;

public class BillCalculator {

	public static double calculateBill(double totalAmt, CustomerType customerType) {
		double billAmt = totalAmt;
		double discount = calculateDiscount(totalAmt, customerType);
		billAmt -= discount;
		return billAmt;
	}

	private static double calculateDiscount(double totalAmt, CustomerType customerType) {
		double discount = 0.0;
		List<DiscountSlab> slabList = DiscountSlabEngine.getDiscountSlabs(customerType);
		for (DiscountSlab slab : slabList) {
			if (totalAmt <= 0) {
				return discount;
			}
			if (totalAmt >= slab.getEnd()) {
				double discountedAmt = slab.getEnd() - slab.getStart();
				discount += (slab.getDiscount() * discountedAmt) / 100;
				totalAmt -= discountedAmt;
			} else {
				discount += (slab.getDiscount() * totalAmt) / 100;
				totalAmt -= slab.getEnd();
			}
		}
		return discount;
	}

}
