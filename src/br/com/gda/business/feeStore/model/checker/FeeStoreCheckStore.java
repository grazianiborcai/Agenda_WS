package br.com.gda.business.feeStore.model.checker;

import java.util.List;

import br.com.gda.business.feeStore.info.FeeStoreInfo;
import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.business.store.model.checker.StoreCheckExist;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;

public final class FeeStoreCheckStore implements ModelChecker<FeeStoreInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelChecker<StoreInfo> checker;
	
	
	public FeeStoreCheckStore(ModelCheckerOption option) {
		checker = new StoreCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<FeeStoreInfo> recordInfos) {
		for (FeeStoreInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(FeeStoreInfo recordInfo) {
		return checker.check(StoreInfo.copyFrom(recordInfo));
	}

	
	
	@Override public boolean getResult() {
		return checker.getResult();
	}

	
	
	@Override public String getFailureExplanation() {
		return checker.getFailureExplanation();
	}

	
	
	@Override public int getFailureCode() {
		return checker.getFailureCode();
	}
}
