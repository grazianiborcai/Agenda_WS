package br.com.mind5.business.phone.model.checker;

import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.masterData.areaPhone.info.AreaneInfo;
import br.com.mind5.masterData.areaPhone.model.checker.AreaneCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class PhoneCheckAreane extends ModelCheckerTemplateForwardV2<PhoneInfo, AreaneInfo> {
	
	public PhoneCheckAreane(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<AreaneInfo> getCheckerHook(ModelCheckerOption option) {
		return new AreaneCheckExist(option);
	}
	
	
	
	@Override protected AreaneInfo toForwardClass(PhoneInfo baseRecord) {
		return AreaneInfo.copyFrom(baseRecord);
	}
}
