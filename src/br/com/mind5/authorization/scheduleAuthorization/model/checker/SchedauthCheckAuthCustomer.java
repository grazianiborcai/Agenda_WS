package br.com.mind5.authorization.scheduleAuthorization.model.checker;

import br.com.mind5.authorization.scheduleAuthorization.info.SchedauthInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.security.userSearch.info.UserarchCopier;
import br.com.mind5.security.userSearch.info.UserarchInfo;
import br.com.mind5.security.userSearch.model.checker.UserarchCheckExistCustomer;

public final class SchedauthCheckAuthCustomer extends ModelCheckerTemplateForward<SchedauthInfo, UserarchInfo> {
	
	public SchedauthCheckAuthCustomer(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<UserarchInfo> getCheckerHook(ModelCheckerOption option) {
		return new UserarchCheckExistCustomer(option);
	}
	
	
	
	@Override protected UserarchInfo toForwardClass(SchedauthInfo baseRecord) {
		return UserarchCopier.copyFromSchedauth(baseRecord);
	}
}
