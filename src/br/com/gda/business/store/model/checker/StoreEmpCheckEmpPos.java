package br.com.gda.business.store.model.checker;

import java.util.List;

import br.com.gda.business.masterData.info.EmpPosInfo;
import br.com.gda.business.masterData.model.checker.EmpPosCheckExist;
import br.com.gda.business.store.info.StoreEmpInfo;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;

public final class StoreEmpCheckEmpPos implements ModelChecker<StoreEmpInfo> {
	private final boolean RESULT_FAILED = false;
	private final boolean RESULT_SUCCESS = true;
	
	private ModelChecker<EmpPosInfo> checker;
	
	
	public StoreEmpCheckEmpPos(ModelCheckerOption option) {
		checker = new EmpPosCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<StoreEmpInfo> recordInfos) {
		for (StoreEmpInfo eachInfo : recordInfos) {
			if (check(eachInfo) == RESULT_FAILED)
				return RESULT_FAILED;
		}
		
		return RESULT_SUCCESS;
	}

	
	
	@Override public boolean check(StoreEmpInfo recordInfo) {
		return checker.check(recordInfo.toEmpPosInfo());
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
