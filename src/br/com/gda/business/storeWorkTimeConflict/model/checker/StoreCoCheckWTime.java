package br.com.gda.business.storeWorkTimeConflict.model.checker;

import java.util.List;

import br.com.gda.business.storeWorkTime.info.StoreWTimeInfo;
import br.com.gda.business.storeWorkTime.model.checker.StoreWTimeCheckExist;
import br.com.gda.business.storeWorkTimeConflict.info.StoreCoInfo;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;

public final class StoreCoCheckWTime implements ModelChecker<StoreCoInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelChecker<StoreWTimeInfo> checker;
	
	
	public StoreCoCheckWTime(ModelCheckerOption option) {
		checker = new StoreWTimeCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<StoreCoInfo> recordInfos) {
		for (StoreCoInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(StoreCoInfo recordInfo) {
		return checker.check(StoreWTimeInfo.copyFrom(recordInfo));
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
