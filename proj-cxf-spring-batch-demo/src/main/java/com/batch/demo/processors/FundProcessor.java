package com.batch.demo.processors;

import org.springframework.batch.item.ItemProcessor;

import com.batch.demo.domain.Fund;

public class FundProcessor implements ItemProcessor<Fund, Fund> {

	@Override
	public Fund process(Fund item) throws Exception {
		//convert each to upper case before saving
		
		String symbol = item.getSymbol().toUpperCase();
		String cusip = item.getCusip().toUpperCase();
		String name = item.getName().toUpperCase();
		
		System.out.println("Processing Fund : " + item);
		 
		return new Fund(symbol, cusip, name);
		
		
	}

}
