package br.com.gda.business.employeeWorkTime.model.checker;

import java.util.List;

import br.com.gda.business.employeeWorkTime.info.EmpWTimeInfo;
import br.com.gda.business.storeWorkTime.info.StoreWTimeInfo;
import br.com.gda.business.storeWorkTime.model.checker.StoreWTimeCheckSWT;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;

public final class EmpWTimeCheckSWT implements ModelChecker<EmpWTimeInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelChecker<StoreWTimeInfo> checker;
	
	
	public EmpWTimeCheckSWT(ModelCheckerOption option) {
		checker = new StoreWTimeCheckSWT(option);
	}
	
	
	
	@Override public boolean check(List<EmpWTimeInfo> recordInfos) {
		for (EmpWTimeInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(EmpWTimeInfo recordInfo) {
		return checker.check(StoreWTimeInfo.copyFrom(recordInfo));
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
