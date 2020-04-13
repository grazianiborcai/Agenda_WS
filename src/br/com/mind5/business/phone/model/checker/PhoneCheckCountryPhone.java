package br.com.mind5.business.phone.model.checker;

import br.com.mind5.business.masterData.info.CountryPhoneInfo;
import br.com.mind5.business.masterData.model.checker.CountryPhoneCheckExist;
import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class PhoneCheckCountryPhone extends ModelCheckerTemplateForwardV2<PhoneInfo, CountryPhoneInfo> {
	
	public PhoneCheckCountryPhone(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<CountryPhoneInfo> getCheckerHook(ModelCheckerOption option) {
		return new CountryPhoneCheckExist(option);
	}
	
	
	
	@Override protected CountryPhoneInfo toForwardClass(PhoneInfo baseRecord) {
		return CountryPhoneInfo.copyFrom(baseRecord);
	}
}
