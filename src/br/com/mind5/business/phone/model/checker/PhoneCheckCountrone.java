package br.com.mind5.business.phone.model.checker;

import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.masterData.countryPhone.info.CountroneInfo;
import br.com.mind5.masterData.countryPhone.model.checker.CountroneCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class PhoneCheckCountrone extends ModelCheckerTemplateForwardV2<PhoneInfo, CountroneInfo> {
	
	public PhoneCheckCountrone(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<CountroneInfo> getCheckerHook(ModelCheckerOption option) {
		return new CountroneCheckExist(option);
	}
	
	
	
	@Override protected CountroneInfo toForwardClass(PhoneInfo baseRecord) {
		return CountroneInfo.copyFrom(baseRecord);
	}
}
