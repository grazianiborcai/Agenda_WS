package br.com.mind5.business.employeeLeaveDate.model.checker;

import br.com.mind5.business.employeeLeaveDate.info.EmplateInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.security.storeAuthorization.info.StorauthInfo;
import br.com.mind5.security.storeAuthorization.model.checker.StorauthCheckExist;

public final class EmplateCheckStorauth extends ModelCheckerTemplateForwardV2<EmplateInfo, StorauthInfo> {
	
	public EmplateCheckStorauth(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<StorauthInfo> getCheckerHook(ModelCheckerOption option) {
		return new StorauthCheckExist(option);
	}
	
	
	
	@Override protected StorauthInfo toForwardClass(EmplateInfo baseRecord) {
		return StorauthInfo.copyFrom(baseRecord);
	}
}
