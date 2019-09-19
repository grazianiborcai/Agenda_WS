package br.com.gda.business.storeWorkTime.model.checker;

import java.util.List;

import br.com.gda.business.storeWorkTime.info.StowotmInfo;
import br.com.gda.business.timeRange.info.TimeRangeInfo;
import br.com.gda.business.timeRange.model.checker.TimeRangeCheckRange;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerTemplateSimple_;

public final class StowotmCheckRange extends ModelCheckerTemplateSimple_<StowotmInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelChecker<TimeRangeInfo> checker;
	
	
	public StowotmCheckRange() {
		checker = new TimeRangeCheckRange();
	}
	
	
	
	@Override public boolean check(List<StowotmInfo> recordInfos) {
		for (StowotmInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(StowotmInfo recordInfo) {
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
