package br.com.mind5.stats.statsStoreAccount.storeAccount.model.checker;

import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.stats.statsStoreAccount.storeAccount.info.StoracInfo;
import br.com.mind5.stats.statsStoreAccount.storeAccountLive.info.StoraciveInfo;
import br.com.mind5.stats.statsStoreAccount.storeAccountLive.model.checker.StoraciveCheckExist;

public final class StoracCheckStoracive extends ModelCheckerTemplateForward<StoracInfo, StoraciveInfo> {
	
	public StoracCheckStoracive(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<StoraciveInfo> getCheckerHook(ModelCheckerOption option) {
		return new StoraciveCheckExist(option);
	}
	
	
	
	@Override protected StoraciveInfo toForwardClass(StoracInfo baseRecord) {
		return StoraciveInfo.copyFrom(baseRecord);
	}
}
