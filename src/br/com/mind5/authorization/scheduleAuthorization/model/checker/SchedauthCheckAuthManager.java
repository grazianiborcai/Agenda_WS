package br.com.mind5.authorization.scheduleAuthorization.model.checker;

import br.com.mind5.authorization.scheduleAuthorization.info.SchedauthInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.security.userSearch.info.UserarchCopier;
import br.com.mind5.security.userSearch.info.UserarchInfo;
import br.com.mind5.security.userSearch.model.checker.UserarchCheckExistManager;

public final class SchedauthCheckAuthManager extends ModelCheckerTemplateForward<SchedauthInfo, UserarchInfo> {
	
	public SchedauthCheckAuthManager(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<UserarchInfo> getCheckerHook(ModelCheckerOption option) {
		return new UserarchCheckExistManager(option);
	}
	
	
	
	@Override protected UserarchInfo toForwardClass(SchedauthInfo baseRecord) {
		return UserarchCopier.copyFromSchedauth(baseRecord);
	}
}
