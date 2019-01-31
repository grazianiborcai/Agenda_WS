package br.com.gda.business.employeeLeaveDate.model.checker;

import java.util.List;

import br.com.gda.business.employeeLeaveDate.info.EmpLDateInfo;
import br.com.gda.business.employeePosition.info.EmposInfo;
import br.com.gda.business.employeePosition.model.checker.EmposCheckExist;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;

public final class EmpLDateCheckStoreEmp implements ModelChecker<EmpLDateInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelChecker<EmposInfo> checker;
	
	
	public EmpLDateCheckStoreEmp(ModelCheckerOption option) {
		checker = new EmposCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<EmpLDateInfo> recordInfos) {
		for (EmpLDateInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(EmpLDateInfo recordInfo) {
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
