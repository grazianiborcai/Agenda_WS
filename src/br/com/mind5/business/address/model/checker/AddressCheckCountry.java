package br.com.mind5.business.address.model.checker;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.masterData.country.info.CountryInfo;
import br.com.mind5.masterData.country.model.checker.CountryCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class AddressCheckCountry extends ModelCheckerTemplateForward<AddressInfo, CountryInfo> {
	
	public AddressCheckCountry(ModelCheckerOption option) {
		super(option);
	}

	

	@Override protected ModelChecker<CountryInfo> getCheckerHook(ModelCheckerOption option) {
		return new CountryCheckExist(option);
	}
	
	
	
	@Override protected CountryInfo toForwardClass(AddressInfo baseRecord) {
		return CountryInfo.copyFrom(baseRecord);
	}
}
