package br.com.mind5.business.employee.model.checker;

import java.util.List;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.business.employeePosition.info.EmposInfo;
import br.com.mind5.business.employeePosition.model.checker.EmposCheckHasEmpItem;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;

public final class EmpCheckHasEmpos implements ModelChecker<EmpInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelChecker<EmposInfo> checker;
	
	
	public EmpCheckHasEmpos(ModelCheckerOption option) {
		checker = new EmposCheckHasEmpItem(option);
	}
	
	
	
	@Override public boolean check(List<EmpInfo> recordInfos) {
		for (EmpInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(EmpInfo recordInfo) {
		return checker.check(EmposInfo.copyFrom(recordInfo));
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
