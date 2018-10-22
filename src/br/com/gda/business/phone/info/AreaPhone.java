package br.com.gda.business.phone.info;

import java.util.HashMap;
import java.util.Map;

import br.com.gda.business.masterData.info.CountryPhone;

public enum AreaPhone {
	BR(CountryPhone.BR, 2) {
	@Override public boolean checkCodArea(int cod) {
		return cod == 11 || cod == 12 || cod == 13 || cod == 14 || cod == 15 || 
			   cod == 16 || cod == 17 || cod == 18 || cod == 19 || cod == 21 || 
			   cod == 22 || cod == 24 || cod == 27 || cod == 28 || cod == 31 || 
			   cod == 32 || cod == 33 || cod == 34 || cod == 35 || cod == 37 || 
			   cod == 38 || cod == 41 || cod == 42 || cod == 43 || cod == 44 || 
			   cod == 45 || cod == 46 || cod == 47 || cod == 48 || cod == 49 || 
			   cod == 51 || cod == 53 || cod == 54 || cod == 55 || cod == 61 || 
			   cod == 62 || cod == 63 || cod == 64 || cod == 65 || cod == 66 || 
			   cod == 67 || cod == 68 || cod == 69 || cod == 71 || cod == 73 || 
			   cod == 74 || cod == 75 || cod == 77 || cod == 79 || cod == 81 || 
			   cod == 82 || cod == 83 || cod == 84 || cod == 85 || cod == 86 || 
			   cod == 87 || cod == 88 || cod == 89 || cod == 91 || cod == 92 || 
			   cod == 93 || cod == 94 || cod == 95 || cod == 96 || cod == 97 || 
			   cod == 98 || cod == 99;
	}
};
	
	
	private final CountryPhone country;
	private final int codeLength;
	private static final Map<CountryPhone, AreaPhone> mapContryArea;
	
	
	static {
		mapContryArea = new HashMap<>();
		
		for (AreaPhone eachElem : AreaPhone.values()) {
			mapContryArea.put(eachElem.getCountry(), eachElem);
		}
	}
	
	
	
	public static AreaPhone getAreaPhone(CountryPhone countryPhone) {
		AreaPhone result = mapContryArea.get(countryPhone);
		
		if (result == null)
			throw new IllegalArgumentException();
		
		return result;
	}
	
	
	
	public static AreaPhone getAreaPhone(int codCountryPhone) {
		AreaPhone result = mapContryArea.get(CountryPhone.getCountryPhone(codCountryPhone));
		
		if (result == null)
			throw new IllegalArgumentException();
		
		return result;
	}
	
	
	
	private AreaPhone(CountryPhone countryPhone, int digitNum) {
		country = countryPhone;
		codeLength = digitNum;
	}
	
	
	
	public CountryPhone getCountry() {
		return country;
	}
	
	
	
	public int getAreaCodeLength() {
		return codeLength;
	}
	
	
	
	abstract public boolean checkCodArea(int cod);
}
