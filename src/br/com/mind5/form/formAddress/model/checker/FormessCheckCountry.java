package br.com.mind5.form.formAddress.model.checker;

import br.com.mind5.form.formAddress.info.FormessInfo;
import br.com.mind5.masterData.country.info.CountryInfo;
import br.com.mind5.masterData.country.model.checker.CountryCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class FormessCheckCountry extends ModelCheckerTemplateForward<FormessInfo, CountryInfo> {
	
	public FormessCheckCountry(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<CountryInfo> getCheckerHook(ModelCheckerOption option) {
		return new CountryCheckExist(option);
	}
	
	
	
	@Override protected CountryInfo toForwardClass(FormessInfo baseRecord) {
		return CountryInfo.copyFrom(baseRecord);
	}
}
