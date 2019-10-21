package br.com.mind5.business.masterData.info.common;

public enum Country {
	BRAZIL("BR", "BRA");

	private final String codCountry;
	private final String codCountryAlpha3;
	
	private Country(String country, String alpha) {
		codCountry = country;
		codCountryAlpha3 = alpha;
	}
	
	
	
	public String getCodCountry() {
		return codCountry;
	}
	
	
	
	public String getCodCountryAlpha3() {
		return codCountryAlpha3;
	}
}
