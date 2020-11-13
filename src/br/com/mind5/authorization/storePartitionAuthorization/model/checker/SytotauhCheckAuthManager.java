package br.com.mind5.authorization.storePartitionAuthorization.model.checker;

import br.com.mind5.authorization.storePartitionAuthorization.info.SytotauhInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.security.userSearch.info.UserarchCopier;
import br.com.mind5.security.userSearch.info.UserarchInfo;
import br.com.mind5.security.userSearch.model.checker.UserarchCheckExistManager;

public final class SytotauhCheckAuthManager extends ModelCheckerTemplateForward<SytotauhInfo, UserarchInfo> {
	
	public SytotauhCheckAuthManager(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<UserarchInfo> getCheckerHook(ModelCheckerOption option) {
		return new UserarchCheckExistManager(option);
	}
	
	
	
	@Override protected UserarchInfo toForwardClass(SytotauhInfo baseRecord) {
		return UserarchCopier.copyFromSytotauh(baseRecord);
	}
}
