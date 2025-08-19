package utilities;

import org.apache.commons.text.RandomStringGenerator;

public class HelperFunctions {
	
    public RandomStringGenerator Str_Gen = new RandomStringGenerator.Builder().withinRange('a','z').build();
	
	public String nameGenerator(int num) {
		return Str_Gen.generate(num);
	}
	
	public String numGenerator(int length) {
		StringBuilder number = new StringBuilder();
		for(int i=0;i<length;i++) {
			number.append((int) (Math.random() * 10) );
		}
		return number.toString();
	}

}
