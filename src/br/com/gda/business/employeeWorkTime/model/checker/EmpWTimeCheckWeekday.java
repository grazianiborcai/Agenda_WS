package br.com.gda.business.employeeWorkTime.model.checker;

import java.util.List;

import br.com.gda.business.employeeWorkTime.info.EmpWTimeInfo;
import br.com.gda.business.masterData.info.WeekdayInfo;
import br.com.gda.business.masterData.model.checker.WeekdayCheckExist;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;

public final class EmpWTimeCheckWeekday implements ModelChecker<EmpWTimeInfo> {
	private final boolean RESULT_FAILED = false;
	private final boolean RESULT_SUCCESS = true;
	
	private ModelChecker<WeekdayInfo> checker;
	
	
	public EmpWTimeCheckWeekday(ModelCheckerOption option) {
		checker = new WeekdayCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<EmpWTimeInfo> recordInfos) {
		for (EmpWTimeInfo eachInfo : recordInfos) {
			if (check(eachInfo) == RESULT_FAILED)
				return RESULT_FAILED;
		}
		
		return RESULT_SUCCESS;
	}

	
	
	@Override public boolean check(EmpWTimeInfo recordInfo) {
		return checker.check(WeekdayInfo.copyFrom(recordInfo));
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
