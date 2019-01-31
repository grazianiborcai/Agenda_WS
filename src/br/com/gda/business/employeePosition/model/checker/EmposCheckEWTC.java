package br.com.gda.business.employeePosition.model.checker;

import java.util.List;

import br.com.gda.business.employeePosition.info.EmposInfo;
import br.com.gda.business.employeeWorkTimeConflict.info.EmpCoInfo;
import br.com.gda.business.employeeWorkTimeConflict.model.checker.EmpCoCheckExist;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;

public final class EmposCheckEWTC implements ModelChecker<EmposInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelChecker<EmpCoInfo> checker;
	
	
	public EmposCheckEWTC(ModelCheckerOption option) {
		checker = new EmpCoCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<EmposInfo> recordInfos) {
		for (EmposInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(EmposInfo recordInfo) {
		return checker.check(EmpCoInfo.copyFrom(recordInfo));
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
