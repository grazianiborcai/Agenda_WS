package br.com.gda.business.storeWorkTime.model.checker;

import java.util.List;

import br.com.gda.business.storeWorkTime.info.StoreWTimeInfo;
import br.com.gda.business.timeRange.info.TimeRangeInfo;
import br.com.gda.business.timeRange.model.checker.TimeRangeCheckRange;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;

public final class StoreWTimeCheckRange extends ModelCheckerTemplateSimple<StoreWTimeInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelChecker<TimeRangeInfo> checker;
	
	
	public StoreWTimeCheckRange() {
		checker = new TimeRangeCheckRange();
	}
	
	
	
	@Override public boolean check(List<StoreWTimeInfo> recordInfos) {
		for (StoreWTimeInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(StoreWTimeInfo recordInfo) {
		return checker.check(TimeRangeInfo.copyFrom(recordInfo));
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
