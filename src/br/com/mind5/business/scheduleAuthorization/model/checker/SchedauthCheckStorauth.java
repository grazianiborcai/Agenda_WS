package br.com.mind5.business.scheduleAuthorization.model.checker;

import br.com.mind5.business.scheduleAuthorization.info.SchedauthInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.security.storeAuthorization.info.StorauthInfo;
import br.com.mind5.security.storeAuthorization.model.checker.StorauthCheckExist;

public final class SchedauthCheckStorauth extends ModelCheckerTemplateForwardV2<SchedauthInfo, StorauthInfo> {
	
	public SchedauthCheckStorauth(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<StorauthInfo> getCheckerHook(ModelCheckerOption option) {
		return new StorauthCheckExist(option);
	}
	
	
	
	@Override protected StorauthInfo toForwardClass(SchedauthInfo baseRecord) {
		return StorauthInfo.copyFrom(baseRecord);
	}
}