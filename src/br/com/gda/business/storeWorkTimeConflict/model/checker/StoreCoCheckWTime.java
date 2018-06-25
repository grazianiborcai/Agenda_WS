package br.com.gda.business.storeWorkTimeConflict.model.checker;

import java.util.List;

import br.com.gda.business.storeWorkTime.info.StoreWTimeInfo;
import br.com.gda.business.storeWorkTime.model.checker.StoreWTimeCheckExist;
import br.com.gda.business.storeWorkTimeConflict.info.StoreCoInfo;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;

public final class StoreCoCheckWTime implements ModelChecker<StoreCoInfo> {
	private final boolean RESULT_FAILED = false;
	private final boolean RESULT_SUCCESS = true;
	
	private ModelChecker<StoreWTimeInfo> checker;
	
	
	public StoreCoCheckWTime(ModelCheckerOption option) {
		checker = new StoreWTimeCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<StoreCoInfo> recordInfos) {
		for (StoreCoInfo eachInfo : recordInfos) {
			if (check(eachInfo) == RESULT_FAILED)
				return RESULT_FAILED;
		}
		
		return RESULT_SUCCESS;
	}

	
	
	@Override public boolean check(StoreCoInfo recordInfo) {
		return checker.check(recordInfo.toStoreWTimeInfo());
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
