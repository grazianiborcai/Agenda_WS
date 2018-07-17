package br.com.gda.business.storeWorkTime.model.checker;

import java.util.List;

import br.com.gda.business.storeWorkTime.info.StoreWTimeInfo;
import br.com.gda.business.storeWorkTimeConflict.info.StoreCoInfo;
import br.com.gda.business.storeWorkTimeConflict.model.checker.StoreCoCheckExist;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;

public class StoreWTimeCheckExistCo implements ModelChecker<StoreWTimeInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelChecker<StoreCoInfo> checker;
	
	
	public StoreWTimeCheckExistCo(ModelCheckerOption option) {
		checker = new StoreCoCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<StoreWTimeInfo> recordInfos) {
		for (StoreWTimeInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(StoreWTimeInfo recordInfo) {
		return checker.check(StoreCoInfo.copyFrom(recordInfo));
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
