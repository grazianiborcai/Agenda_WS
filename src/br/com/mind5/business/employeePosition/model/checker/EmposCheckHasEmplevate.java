package br.com.mind5.business.employeePosition.model.checker;

import java.util.List;

import br.com.mind5.business.employeeLeaveDate.info.EmplevateInfo;
import br.com.mind5.business.employeeLeaveDate.model.checker.EmplevateCheckHasEmposItem;
import br.com.mind5.business.employeePosition.info.EmposInfo;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;

public final class EmposCheckHasEmplevate implements ModelChecker<EmposInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelChecker<EmplevateInfo> checker;
	
	
	public EmposCheckHasEmplevate(ModelCheckerOption option) {
		checker = new EmplevateCheckHasEmposItem(option);
	}
	
	
	
	@Override public boolean check(List<EmposInfo> recordInfos) {
		for (EmposInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(EmposInfo recordInfo) {
		return checker.check(EmplevateInfo.copyFrom(recordInfo));
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
