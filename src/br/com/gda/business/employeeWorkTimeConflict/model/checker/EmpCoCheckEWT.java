package br.com.gda.business.employeeWorkTimeConflict.model.checker;

import java.util.List;

import br.com.gda.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.gda.business.employeeWorkTime.model.checker.EmpwotmCheckExist;
import br.com.gda.business.employeeWorkTimeConflict.info.EmpCoInfo;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;

public final class EmpCoCheckEWT implements ModelChecker<EmpCoInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelChecker<EmpwotmInfo> checker;
	
	
	public EmpCoCheckEWT(ModelCheckerOption option) {
		checker = new EmpwotmCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<EmpCoInfo> recordInfos) {
		for (EmpCoInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(EmpCoInfo recordInfo) {
		return checker.check(EmpwotmInfo.copyFrom(recordInfo));
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
