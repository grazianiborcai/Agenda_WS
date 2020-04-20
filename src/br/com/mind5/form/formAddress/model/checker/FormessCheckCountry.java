package br.com.mind5.form.formAddress.model.checker;

import br.com.mind5.form.formAddress.info.FormessInfo;
import br.com.mind5.masterData.country.info.CountryInfo;
import br.com.mind5.masterData.country.model.checker.CountryCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class FormessCheckCountry extends ModelCheckerTemplateForwardV2<FormessInfo, CountryInfo> {
	
	public FormessCheckCountry(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<CountryInfo> getCheckerHook(ModelCheckerOption option) {
		return new CountryCheckExist(option);
	}
	
	
	
	@Override protected CountryInfo toForwardClass(FormessInfo baseRecord) {
		return CountryInfo.copyFrom(baseRecord);
	}
}
