package br.com.gda.business.materialEmployee.model.chekcer;

import java.util.List;

import br.com.gda.business.materialEmployee.info.MatEmpInfo;
import br.com.gda.business.materialStore.info.MatStoreInfo;
import br.com.gda.business.materialStore.model.checker.MatStoreCheckExist;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;

public final class MatEmpCheckMatStore implements ModelChecker<MatEmpInfo> {
	private final boolean RESULT_FAILED = false;
	private final boolean RESULT_SUCCESS = true;
	
	private ModelChecker<MatStoreInfo> checker;
	
	
	public MatEmpCheckMatStore(ModelCheckerOption option) {
		checker = new MatStoreCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<MatEmpInfo> recordInfos) {
		for (MatEmpInfo eachInfo : recordInfos) {
			if (check(eachInfo) == RESULT_FAILED)
				return RESULT_FAILED;
		}
		
		return RESULT_SUCCESS;
	}

	
	
	@Override public boolean check(MatEmpInfo recordInfo) {
		return checker.check(MatStoreInfo.copyFrom(recordInfo));
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
