package br.com.gda.business.employeWorkTimeConflict.model.checker;

import java.util.List;

import br.com.gda.business.employeWorkTimeConflict.info.EmpCoInfo;
import br.com.gda.business.employeeWorkTime.info.EmpWTimeInfo;
import br.com.gda.business.employeeWorkTime.model.checker.EmpWTimeCheckExist;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;

public final class EmpCoCheckWTime implements ModelChecker<EmpCoInfo> {
	private final boolean RESULT_FAILED = false;
	private final boolean RESULT_SUCCESS = true;
	
	private ModelChecker<EmpWTimeInfo> checker;
	
	
	public EmpCoCheckWTime(ModelCheckerOption option) {
		checker = new EmpWTimeCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<EmpCoInfo> recordInfos) {
		for (EmpCoInfo eachInfo : recordInfos) {
			if (check(eachInfo) == RESULT_FAILED)
				return RESULT_FAILED;
		}
		
		return RESULT_SUCCESS;
	}

	
	
	@Override public boolean check(EmpCoInfo recordInfo) {
		return checker.check(recordInfo.toEmpWTimeInfo());
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
