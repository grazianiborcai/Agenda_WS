package br.com.mind5.form.formPhone.model.checker;

import br.com.mind5.form.formPhone.info.FormoneInfo;
import br.com.mind5.masterData.country.info.CountryInfo;
import br.com.mind5.masterData.country.model.checker.CountryCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class FormoneCheckCountry extends ModelCheckerTemplateForward<FormoneInfo, CountryInfo> {
	
	public FormoneCheckCountry(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<CountryInfo> getCheckerHook(ModelCheckerOption option) {
		return new CountryCheckExist(option);
	}
	
	
	
	@Override protected CountryInfo toForwardClass(FormoneInfo baseRecord) {
		return CountryInfo.copyFrom(baseRecord);
	}
}
