package br.com.gda.business.employeeLeaveDate.model.checker;

import java.util.List;

import br.com.gda.business.employeeLeaveDate.info.EmpLDateInfo;
import br.com.gda.business.timeRange.info.TimeRangeInfo;
import br.com.gda.business.timeRange.model.checker.TimeRangeCheckRange;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerTemplate;

public final class EmpLDateCheckTimeRange extends ModelCheckerTemplate<EmpLDateInfo> {
	private final boolean RESULT_FAILED = false;
	private final boolean RESULT_SUCCESS = true;
	
	private ModelChecker<TimeRangeInfo> checker;
	
	
	public EmpLDateCheckTimeRange() {
		checker = new TimeRangeCheckRange();
	}
	
	
	
	@Override public boolean check(List<EmpLDateInfo> recordInfos) {
		for (EmpLDateInfo eachInfo : recordInfos) {
			if (check(eachInfo) == RESULT_FAILED)
				return RESULT_FAILED;
		}
		
		return RESULT_SUCCESS;
	}

	
	
	@Override public boolean check(EmpLDateInfo recordInfo) {
		return checker.check(recordInfo.toTimeRangeInfo());
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
