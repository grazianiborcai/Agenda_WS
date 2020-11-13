package br.com.mind5.business.employeePosition.model.checker;

import br.com.mind5.authorization.storeAuthorization.info.StorauthInfo;
import br.com.mind5.authorization.storeAuthorization.model.checker.StorauthCheckExist;
import br.com.mind5.business.employeePosition.info.EmposInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class EmposCheckStorauth extends ModelCheckerTemplateForward<EmposInfo, StorauthInfo> {
	
	public EmposCheckStorauth(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<StorauthInfo> getCheckerHook(ModelCheckerOption option) {
		return new StorauthCheckExist(option);
	}
	
	
	
	@Override protected StorauthInfo toForwardClass(EmposInfo baseRecord) {
		return StorauthInfo.copyFrom(baseRecord);
	}
}
