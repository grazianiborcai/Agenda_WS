package br.com.gda.business.employeeLeaveDate.model.checker;

import java.util.List;

import br.com.gda.business.employeeLeaveDate.info.EmpLDateInfo;
import br.com.gda.business.storeEmployee.info.StoreEmpInfo;
import br.com.gda.business.storeEmployee.model.checker.StoreEmpCheckExist;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;

public final class EmpLDateCheckStoreEmp implements ModelChecker<EmpLDateInfo> {
	private final boolean RESULT_FAILED = false;
	private final boolean RESULT_SUCCESS = true;
	
	private ModelChecker<StoreEmpInfo> checker;
	
	
	public EmpLDateCheckStoreEmp(ModelCheckerOption option) {
		checker = new StoreEmpCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<EmpLDateInfo> recordInfos) {
		for (EmpLDateInfo eachInfo : recordInfos) {
			if (check(eachInfo) == RESULT_FAILED)
				return RESULT_FAILED;
		}
		
		return RESULT_SUCCESS;
	}

	
	
	@Override public boolean check(EmpLDateInfo recordInfo) {
		return checker.check(StoreEmpInfo.copyFrom(recordInfo));
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
