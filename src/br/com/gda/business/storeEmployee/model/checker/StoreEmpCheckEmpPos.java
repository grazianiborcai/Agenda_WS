package br.com.gda.business.storeEmployee.model.checker;

import java.util.List;

import br.com.gda.business.masterData.info.EmpPosInfo;
import br.com.gda.business.masterData.model.checker.EmpPosCheckExist;
import br.com.gda.business.storeEmployee.info.StoreEmpInfo;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;

public final class StoreEmpCheckEmpPos implements ModelChecker<StoreEmpInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelChecker<EmpPosInfo> checker;
	
	
	public StoreEmpCheckEmpPos(ModelCheckerOption option) {
		checker = new EmpPosCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<StoreEmpInfo> recordInfos) {
		for (StoreEmpInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(StoreEmpInfo recordInfo) {
		return checker.check(EmpPosInfo.copyFrom(recordInfo));
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
