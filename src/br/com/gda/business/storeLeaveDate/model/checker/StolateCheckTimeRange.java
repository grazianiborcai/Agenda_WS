package br.com.gda.business.storeLeaveDate.model.checker;

import java.util.List;

import br.com.gda.business.storeLeaveDate.info.StolateInfo;
import br.com.gda.business.timeRange.info.DateTimeRangeInfo;
import br.com.gda.business.timeRange.model.checker.DateTimeRangeCheckRange;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerTemplateSimple_;

public final class StolateCheckTimeRange extends ModelCheckerTemplateSimple_<StolateInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelChecker<DateTimeRangeInfo> checker;
	
	
	public StolateCheckTimeRange() {
		checker = new DateTimeRangeCheckRange();
	}
	
	
	
	@Override public boolean check(List<StolateInfo> recordInfos) {
		for (StolateInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(StolateInfo recordInfo) {
		return checker.check(DateTimeRangeInfo.copyFrom(recordInfo));
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
