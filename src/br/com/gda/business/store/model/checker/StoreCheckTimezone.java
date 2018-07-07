package br.com.gda.business.store.model.checker;

import java.util.List;

import br.com.gda.business.masterData.info.TimezoneInfo;
import br.com.gda.business.masterData.model.checker.TimezoneCheckExist;
import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;

public final class StoreCheckTimezone implements ModelChecker<StoreInfo> {
	private final boolean RESULT_FAILED = false;
	private final boolean RESULT_SUCCESS = true;
	
	private ModelChecker<TimezoneInfo> checker;
	
	
	public StoreCheckTimezone(ModelCheckerOption option) {
		checker = new TimezoneCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<StoreInfo> recordInfos) {
		for (StoreInfo eachInfo : recordInfos) {
			if (check(eachInfo) == RESULT_FAILED)
				return RESULT_FAILED;
		}
		
		return RESULT_SUCCESS;
	}

	
	
	@Override public boolean check(StoreInfo recordInfo) {
		return checker.check(TimezoneInfo.copyFrom(recordInfo));
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
