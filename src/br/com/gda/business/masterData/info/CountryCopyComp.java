package br.com.gda.business.masterData.info;

import br.com.gda.business.company.info.CompInfo;
import br.com.gda.info.InfoCopierTemplate;

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
