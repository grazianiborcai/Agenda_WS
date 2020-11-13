package br.com.mind5.authorization.storePartitionAuthorization.model.checker;

import br.com.mind5.authorization.storePartitionAuthorization.info.SytotauhInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.security.userSearch.info.UserarchCopier;
import br.com.mind5.security.userSearch.info.UserarchInfo;
import br.com.mind5.security.userSearch.model.checker.UserarchCheckExistOwner;

public final class SytotauhCheckAuthOwner extends ModelCheckerTemplateForward<SytotauhInfo, UserarchInfo> {
	
	public SytotauhCheckAuthOwner(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<UserarchInfo> getCheckerHook(ModelCheckerOption option) {
		return new UserarchCheckExistOwner(option);
	}
	
	
	
	@Override protected UserarchInfo toForwardClass(SytotauhInfo baseRecord) {
		return UserarchCopier.copyFromSytotauh(baseRecord);
	}
}
