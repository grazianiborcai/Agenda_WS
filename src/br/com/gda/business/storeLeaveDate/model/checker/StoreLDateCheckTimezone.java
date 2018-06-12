package br.com.gda.business.storeLeaveDate.model.checker;

import java.util.List;

import br.com.gda.business.masterData.info.TimezoneInfo;
import br.com.gda.business.masterData.model.checker.TimezoneCheckExist;
import br.com.gda.business.storeLeaveDate.info.StoreLDateInfo;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;

public final class StoreLDateCheckTimezone implements ModelChecker<StoreLDateInfo> {
	private final boolean RESULT_FAILED = false;
	private final boolean RESULT_SUCCESS = true;
	
	private ModelChecker<TimezoneInfo> checker;
	
	
	public StoreLDateCheckTimezone(ModelCheckerOption option) {
		checker = new TimezoneCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<StoreLDateInfo> recordInfos) {
		for (StoreLDateInfo eachInfo : recordInfos) {
			if (check(eachInfo) == RESULT_FAILED)
				return RESULT_FAILED;
		}
		
		return RESULT_SUCCESS;
	}

	
	
	@Override public boolean check(StoreLDateInfo recordInfo) {
		return checker.check(recordInfo.toTimezoneInfo());
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
