package br.com.mind5.business.phone.model.checker;

import br.com.mind5.business.masterData.info.AreaPhoneInfo;
import br.com.mind5.business.masterData.model.checker.AreaPhoneCheckExist;
import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class PhoneCheckArea extends ModelCheckerTemplateForwardV2<PhoneInfo, AreaPhoneInfo> {
	
	public PhoneCheckArea(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<AreaPhoneInfo> getCheckerHook(ModelCheckerOption option) {
		return new AreaPhoneCheckExist(option);
	}
	
	
	
	@Override protected AreaPhoneInfo toForwardClass(PhoneInfo baseRecord) {
		return AreaPhoneInfo.copyFrom(baseRecord);
	}
}
