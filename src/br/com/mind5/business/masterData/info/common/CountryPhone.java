package br.com.mind5.business.masterData.info.common;

public enum CountryPhone {
	BRAZIL("BR", 55);

	private final String codCountry;
	private final int codCountryPhone;
	
	private CountryPhone(String country, int phone) {
		codCountry = country;
		codCountryPhone = phone;
	}
	
	
	
	public String getCodCountry() {
		return codCountry;
	}
	
	
	
	public int getCodCountryPhone() {
		return codCountryPhone;
	}
}
