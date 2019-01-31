package br.com.gda.business.employeePosition.model.checker;

import java.util.List;

import br.com.gda.business.employeePosition.info.EmposInfo;
import br.com.gda.business.employeeWorkTime.info.EmpWTimeInfo;
import br.com.gda.business.employeeWorkTime.model.checker.EmpWTimeCheckExist;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;

public final class EmposCheckEWT implements ModelChecker<EmposInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelChecker<EmpWTimeInfo> checker;
	
	
	public EmposCheckEWT(ModelCheckerOption option) {
		checker = new EmpWTimeCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<EmposInfo> recordInfos) {
		for (EmposInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(EmposInfo recordInfo) {
		return checker.check(EmpWTimeInfo.copyFrom(recordInfo));
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
