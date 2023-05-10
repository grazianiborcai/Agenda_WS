package br.com.mind5.masterData.stateSearch.info;

import br.com.mind5.info.InfoSetterTemplate;
import br.com.mind5.masterData.country.info.Country;

public final class StatarchSetterCountryBR extends InfoSetterTemplate<StatarchInfo> {
	
	@Override protected StatarchInfo setAttrHook(StatarchInfo recordInfo) {
		recordInfo.codCountry = Country.BRAZIL.getCodCountry();
		return recordInfo;
	}
}
