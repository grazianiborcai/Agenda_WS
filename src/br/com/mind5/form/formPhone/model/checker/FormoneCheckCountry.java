package br.com.mind5.form.formPhone.model.checker;

import br.com.mind5.business.masterData.info.CountryInfo;
import br.com.mind5.business.masterData.model.checker.CountryCheckExist;
import br.com.mind5.form.formPhone.info.FormoneInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class FormoneCheckCountry extends ModelCheckerTemplateForwardV2<FormoneInfo, CountryInfo> {
	
	public FormoneCheckCountry(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<CountryInfo> getCheckerHook(ModelCheckerOption option) {
		return new CountryCheckExist(option);
	}
	
	
	
	@Override protected CountryInfo toForwardClass(FormoneInfo baseRecord) {
		return CountryInfo.copyFrom(baseRecord);
	}
}
