package br.com.gda.business.store.model.checker;

import java.util.List;

import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.business.storeLeaveDate.info.StolevateInfo;
import br.com.gda.business.storeLeaveDate.model.checker.StolevateCheckHasItem;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;

public final class StoreCheckHasStolevate implements ModelChecker<StoreInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelChecker<StolevateInfo> checker;
	
	
	public StoreCheckHasStolevate(ModelCheckerOption option) {
		checker = new StolevateCheckHasItem(option);
	}
	
	
	
	@Override public boolean check(List<StoreInfo> recordInfos) {
		for (StoreInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(StoreInfo recordInfo) {
		return checker.check(StolevateInfo.copyFrom(recordInfo));
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
