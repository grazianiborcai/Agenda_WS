package br.com.mind5.stats.statsStoreDashboard.model.checker;

import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.security.userSearch.info.UserarchInfo;
import br.com.mind5.security.userSearch.model.checker.UserarchCheckExistOwner;
import br.com.mind5.stats.statsStoreDashboard.info.StorashInfo;

public final class StorashCheckAuthOwner extends ModelCheckerTemplateForward<StorashInfo, UserarchInfo> {
	
	public StorashCheckAuthOwner(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<UserarchInfo> getCheckerHook(ModelCheckerOption option) {
		return new UserarchCheckExistOwner(option);
	}
	
	
	
	@Override protected UserarchInfo toForwardClass(StorashInfo baseRecord) {
		return UserarchInfo.copyFrom(baseRecord);
	}
}
