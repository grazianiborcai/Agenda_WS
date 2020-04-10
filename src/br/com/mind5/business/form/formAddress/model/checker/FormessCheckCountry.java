package br.com.mind5.business.form.formAddress.model.checker;

import br.com.mind5.business.form.formAddress.info.FormessInfo;
import br.com.mind5.business.masterData.info.CountryInfo;
import br.com.mind5.business.masterData.model.checker.CountryCheckExist;
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
