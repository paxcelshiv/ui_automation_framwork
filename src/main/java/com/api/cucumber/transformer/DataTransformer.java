package com.api.cucumber.transformer;

import cucumber.api.Transformer;

public class DataTransformer extends Transformer<String>{

	@Override
	public String transform(String value) {
		// TODO Auto-generated method stub
		return "ModifiedData"+value;
	}

}
