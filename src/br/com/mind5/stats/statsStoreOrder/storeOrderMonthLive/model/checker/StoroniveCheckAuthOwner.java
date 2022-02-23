package br.com.mind5.stats.statsStoreOrder.storeOrderMonthLive.model.checker;

import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.security.userSearch.info.UserarchInfo;
import br.com.mind5.security.userSearch.model.checker.UserarchCheckExistOwner;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonthLive.info.StoroniveInfo;

public final class StoroniveCheckAuthOwner extends ModelCheckerTemplateForward<StoroniveInfo, UserarchInfo> {
	
	public StoroniveCheckAuthOwner(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<UserarchInfo> getCheckerHook(ModelCheckerOption option) {
		return new UserarchCheckExistOwner(option);
	}
	
	
	
	@Override protected UserarchInfo toForwardClass(StoroniveInfo baseRecord) {
		return UserarchInfo.copyFrom(baseRecord);
	}
}
