package br.com.gda.business.employeeLeaveDate.model.checker;

import java.util.List;

import br.com.gda.business.employeeLeaveDate.info.EmplevateInfo;
import br.com.gda.business.timeRange.info.DateTimeRangeInfo;
import br.com.gda.business.timeRange.model.checker.DateTimeRangeCheckRange;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerTemplateSimple_;

public final class EmplevateCheckTimeRange extends ModelCheckerTemplateSimple_<EmplevateInfo> {
	private ModelChecker<DateTimeRangeInfo> checker;
	
	
	public EmplevateCheckTimeRange() {
		checker = new DateTimeRangeCheckRange();
	}
	
	
	
	@Override public boolean check(List<EmplevateInfo> recordInfos) {
		for (EmplevateInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(EmplevateInfo recordInfo) {
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
