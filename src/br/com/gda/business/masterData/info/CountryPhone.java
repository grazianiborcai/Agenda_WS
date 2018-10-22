package br.com.gda.business.masterData.info;

import java.util.HashMap;
import java.util.Map;

public enum CountryPhone {
	BR(55);
	
	
	private final int codCountryPhone;
	private static final Map<Integer, CountryPhone> mapCodeCountries;
	
	
	static {
		mapCodeCountries = new HashMap<>();
		
		for (CountryPhone eachElem : CountryPhone.values()) {
			mapCodeCountries.put(eachElem.getCodCountryPhone(), eachElem);
		}
	}
	
	
	
	public static CountryPhone getCountryPhone(int codCountryPhone) {
		CountryPhone result = mapCodeCountries.get(codCountryPhone);
		
		if (result == null)
			throw new IllegalArgumentException();
		
		return result;
	}
	
	
	
	private CountryPhone(int cod) {
		codCountryPhone = cod;
	}
	
	
	
	public int getCodCountryPhone() {
		return codCountryPhone;
	}
}
