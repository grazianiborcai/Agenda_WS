package br.com.gda.business.storeEmployee.model.checker;

import java.util.List;

import br.com.gda.business.employeeWorkTime.info.EmpWTimeInfo;
import br.com.gda.business.employeeWorkTime.model.checker.EmpWTimeCheckExist;
import br.com.gda.business.storeEmployee.info.StoreEmpInfo;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;

public final class StoreEmpCheckEWT implements ModelChecker<StoreEmpInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelChecker<EmpWTimeInfo> checker;
	
	
	public StoreEmpCheckEWT(ModelCheckerOption option) {
		checker = new EmpWTimeCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<StoreEmpInfo> recordInfos) {
		for (StoreEmpInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(StoreEmpInfo recordInfo) {
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
