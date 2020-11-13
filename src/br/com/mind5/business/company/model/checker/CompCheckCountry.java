package br.com.mind5.business.company.model.checker;

import br.com.mind5.business.company.info.CompInfo;
import br.com.mind5.masterData.country.info.CountryCopier;
import br.com.mind5.masterData.country.info.CountryInfo;
import br.com.mind5.masterData.country.model.checker.CountryCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class CompCheckCountry extends ModelCheckerTemplateForward<CompInfo, CountryInfo> {
	
	public CompCheckCountry(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<CountryInfo> getCheckerHook(ModelCheckerOption option) {
		return new CountryCheckExist(option);
	}
	
	
	
	@Override protected CountryInfo toForwardClass(CompInfo baseRecord) {
		return CountryCopier.copyFromComp(baseRecord);
	}
}
