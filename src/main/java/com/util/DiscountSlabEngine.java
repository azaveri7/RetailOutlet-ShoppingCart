package com.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.model.CustomerType;
import com.model.DiscountSlab;

public class DiscountSlabEngine {

	private static Map<CustomerType, List<DiscountSlab>> customerDiscountMap = new HashMap<>();

	static {
		List<DiscountSlab> regularSlabList = new ArrayList<>();
		List<DiscountSlab> premiumSlabList = new ArrayList<>();

		regularSlabList.add(new DiscountSlab(0.0, 5000.0, 0.0));
		regularSlabList.add(new DiscountSlab(5000.0, 10000.0, 10.0));
		regularSlabList.add(new DiscountSlab(10000.0, Double.MAX_VALUE, 20.0));

		premiumSlabList.add(new DiscountSlab(0.0, 4000.0, 10.0));
		premiumSlabList.add(new DiscountSlab(4000.0, 8000.0, 15.0));
		premiumSlabList.add(new DiscountSlab(8000.0, 12000.0, 20.0));
		premiumSlabList.add(new DiscountSlab(12000.0, Double.MAX_VALUE, 30.0));

		customerDiscountMap.put(CustomerType.REGULAR, regularSlabList);
		customerDiscountMap.put(CustomerType.PREMIUM, premiumSlabList);
	}

	public static List<DiscountSlab> getDiscountSlabs(CustomerType customerType) {
		List<DiscountSlab> slabList = new ArrayList<>();
		switch (customerType) {
		case REGULAR:
			/*
			 * slabList.add(new DiscountSlab(0.0, 5000.0, 0.0)); slabList.add(new
			 * DiscountSlab(5000.0, 10000.0, 10.0)); slabList.add(new DiscountSlab(10000.0,
			 * Double.MAX_VALUE, 20.0));
			 */
			slabList = customerDiscountMap.get(CustomerType.REGULAR);
			break;
		case PREMIUM:
			/*
			 * slabList.add(new DiscountSlab(0.0, 4000.0, 10.0)); slabList.add(new
			 * DiscountSlab(4000.0, 8000.0, 15.0)); slabList.add(new DiscountSlab(8000.0,
			 * 12000.0, 20.0)); slabList.add(new DiscountSlab(12000.0, Double.MAX_VALUE,
			 * 30.0));
			 */
			slabList = customerDiscountMap.get(CustomerType.PREMIUM);
			break;
		}
		return slabList;
	}

}
