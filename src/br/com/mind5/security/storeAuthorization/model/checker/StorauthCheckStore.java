package br.com.mind5.security.storeAuthorization.model.checker;

import java.util.List;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.store.model.checker.StoreCheckExist;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.security.storeAuthorization.info.StorauthInfo;

public final class StorauthCheckStore implements ModelChecker<StorauthInfo> {
	private final boolean RESULT_FAILED = false;
	private final boolean RESULT_SUCCESS = true;
	
	private ModelChecker<StoreInfo> checker;
	
	
	public StorauthCheckStore(ModelCheckerOption option) {
		checker = new StoreCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<StorauthInfo> recordInfos) {
		for (StorauthInfo eachInfo : recordInfos) {
			if (check(eachInfo) == RESULT_FAILED)
				return RESULT_FAILED;
		}
		
		return RESULT_SUCCESS;
	}

	
	
	@Override public boolean check(StorauthInfo recordInfo) {
		return checker.check(StoreInfo.copyFrom(recordInfo));
	}

	
	
	@Override public boolean getResult() {
		return checker.getResult();
	}

	
	
	@Override public String getFailMessage() {
		return checker.getFailMessage();
	}

	
	
	@Override public int getFailCode() {
		return checker.getFailCode();
	}
}
