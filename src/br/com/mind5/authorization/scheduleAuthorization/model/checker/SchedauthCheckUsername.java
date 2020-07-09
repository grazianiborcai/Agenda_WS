package br.com.mind5.authorization.scheduleAuthorization.model.checker;

import br.com.mind5.authorization.scheduleAuthorization.info.SchedauthInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.security.username.info.UsernameInfo;
import br.com.mind5.security.username.model.checker.UsernameCheckExist;

public final class SchedauthCheckUsername extends ModelCheckerTemplateForwardV2<SchedauthInfo, UsernameInfo> {
	
	public SchedauthCheckUsername(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<UsernameInfo> getCheckerHook(ModelCheckerOption option) {
		return new UsernameCheckExist(option);
	}
	
	
	
	@Override protected UsernameInfo toForwardClass(SchedauthInfo baseRecord) {
		return UsernameInfo.copyFrom(baseRecord);
	}
}
