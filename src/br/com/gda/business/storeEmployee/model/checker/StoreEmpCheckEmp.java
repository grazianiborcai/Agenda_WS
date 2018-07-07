package br.com.gda.business.storeEmployee.model.checker;

import java.util.List;

import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.business.employee.model.checker.EmpCheckExistKey;
import br.com.gda.business.storeEmployee.info.StoreEmpInfo;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;

public final class StoreEmpCheckEmp implements ModelChecker<StoreEmpInfo> {
	private final boolean RESULT_FAILED = false;
	private final boolean RESULT_SUCCESS = true;
	
	private ModelChecker<EmpInfo> checker;
	
	
	public StoreEmpCheckEmp(ModelCheckerOption option) {
		checker = new EmpCheckExistKey(option);
	}
	
	
	
	@Override public boolean check(List<StoreEmpInfo> recordInfos) {
		for (StoreEmpInfo eachInfo : recordInfos) {
			if (check(eachInfo) == RESULT_FAILED)
				return RESULT_FAILED;
		}
		
		return RESULT_SUCCESS;
	}

	
	
	@Override public boolean check(StoreEmpInfo recordInfo) {
		return checker.check(EmpInfo.copyFrom(recordInfo));
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
