package br.com.mind5.masterData.countryPhone.info;

public enum Countrone {
	BRAZIL("BR", 55);

	private final String codCountry;
	private final int codCountryPhone;
	
	private Countrone(String country, int phone) {
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
