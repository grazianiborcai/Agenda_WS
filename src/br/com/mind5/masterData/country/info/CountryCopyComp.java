package br.com.mind5.masterData.country.info;

import br.com.mind5.business.company.info.CompInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class CountryCopyComp extends InfoCopierTemplate<CountryInfo, CompInfo>{
	
	public CountryCopyComp() {
		super();
	}
	
	
	
	@Override protected CountryInfo makeCopyHook(CompInfo source) {
		CountryInfo result = new CountryInfo();
		result.codCountry = source.codCountryLegal;
		return result;
	}
}
